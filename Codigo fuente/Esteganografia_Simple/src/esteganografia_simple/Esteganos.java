package esteganografia_simple;

import java.awt.Color;
import java.awt.image.BufferedImage;
/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class Esteganos {
    /* firma= permite reconocer si una foto tiene o no un mensaje oculto */
    private String firma="jc";
    /* Almacenara el tamaño del mensaje mas el tamaño de la firma (2) mas su propio tamaño (2) */
    private int Longitud=0;
    //la imagen
    private BufferedImage foto=null;
    private int r,g,b;
    private Color color;
    //almacenara el mensaje descompuesto en un array binario
    private String mensaje_binario;
    private String mensaje_original;
    private int contador = 0;

    public Esteganos(){}

    /* Dado el mensaje (String) que se quiere ocultar, lo une a la firma
       como a la longitud total del mensaje */
    private void SetMensaje(String mensaje){
        String bi="";
        //el tamaño total del mensaje
        Longitud = mensaje.length() + firma.length() * 2;
        //transforma el valor ENTERO de la longitud en un valor BINARIO
        for( int i = 15; i>=0; i--){
           bi = bi + ( ( ( Longitud & ( 1<<i ) ) > 0 ) ? "1" : "0" ) ;
        }
        //concatena todo el mensaje
        mensaje_binario = getMensajeToBinary(firma) + bi + getMensajeToBinary(mensaje);
    }

    /* el nombre lo dice todo */
    public void OcultarMensaje(BufferedImage f,String mensaje){
        int tmp_count=0;
        //llamada a un procedimiento privado
        SetMensaje(mensaje);
        //crea una imagen con la que se trabajara
        foto = new BufferedImage(f.getWidth(), f.getHeight(), BufferedImage.TYPE_INT_RGB);
        //recorre toda la imagen pixel a pixel añadiendo 1 y 0 en los bits LSB
        for(int fila=0;fila<foto.getHeight();fila++){
          for(int columna=0;columna<foto.getWidth();columna++){
                //se obtiene el color del pixel en coordenadas (i,j)
                color = new Color( f.getRGB(columna, fila) );
                //mientras exista un mensaje, se procede a reemplazar los LSB
                if(tmp_count<=this.mensaje_binario.length()){
                    //se convierten a su equivalente en binario
                    String red = toBinary( (byte) color.getRed() );
                    String verde = toBinary( (byte) color.getGreen() );
                    String azul = toBinary( (byte) color.getBlue() );
                    //se reemplaza el ultimo bits
                    red = ReemplazarLSB(red);
                    verde = ReemplazarLSB(verde);
                    azul = ReemplazarLSB(azul);
                    //cambia de binario a entero
                    r = Integer.parseInt(red ,2);
                    g = Integer.parseInt(verde ,2);
                    b = Integer.parseInt(azul ,2);
                }else{
                   r = color.getRed();
                   g = color.getGreen();
                   b = color.getBlue();
                }
                //se coloca en la nueva imagen con los valores en blanco y negro
                foto.setRGB(columna, fila, new Color(r,g,b).getRGB());
                tmp_count+=3;
          }
        }
    }

   //lee los primeros 6 pixeles para forma los bits necesarios para "jc" devuelve TRUE/FALSE
   private boolean leerfirma(BufferedImage f){
       boolean ok=false;
       String t = "";
        for(int j=0;j<6;j++){
            color = new Color(f.getRGB(j, 0));
            String red = toBinary( (byte) color.getRed() );
            String verde = toBinary( (byte) color.getGreen() );
            String azul = toBinary( (byte) color.getBlue() );
            red = getLSB(red);
            verde = getLSB(verde);
            azul = getLSB(azul);
            t = t + red + verde + azul;
        }          
        if( toChar(t.substring(0, 8)).equals("j") &&  toChar(t.substring(8, 16)).equals("c") ){
            ok=true;
        }
       return ok;
   }

   /* pues que te digo extrae la parte que corresponde al tamaño total del mensaje */
   private void LeerLongitudDelMensaje(BufferedImage f){
        String t = "";
        for(int j=5;j<12;j++){
            color = new Color(f.getRGB(j,0));
            String red = toBinary( (byte) color.getRed() );
            String verde = toBinary( (byte) color.getGreen() );
            String azul = toBinary( (byte) color.getBlue() );
            red = getLSB(red);
            verde = getLSB(verde);
            azul = getLSB(azul);
            t = t + red + verde + azul;
        }
        this.Longitud = toCharInt(t.substring(1, 17));        
      }

      /* extrae los bits de la imagen y forma de nuevo el mensaje oculto */
      public String getMensajeToImage(BufferedImage f){
        //busca que la imagen tenga la firma
        mensaje_original="No existe ningún mensaje oculto";
        if( leerfirma(f) ){//si la firma existe continua
            //llama a funcion privada
            LeerLongitudDelMensaje(f);
            //
            String[] s = new String[this.Longitud];
            String tmp="";
            //recorre toda la imagen pixel x pixel
            for(int fila=0;fila<f.getHeight();fila++){
                for(int columna=0;columna<f.getWidth();columna++){
                    //se obtiene el color del pixel en coordenadas (i,j)
                    color = new Color(f.getRGB(columna, fila));
                    //se convierten a su equivalente en binario
                    String red = toBinary( (byte) color.getRed() );
                    String verde = toBinary( (byte) color.getGreen() );
                    String azul = toBinary( (byte) color.getBlue() );
                    //se obtiene el bits LSB
                    red = getLSB(red);
                    verde = getLSB(verde);
                    azul = getLSB(azul);
                    //cuando se termino de leer todo el mensaje se sale
                    if(tmp.length()<=(this.Longitud*8)){
                        tmp = tmp + red + verde + azul;
                    }else{
                        break;
                    }
                }
            }
            //el String obtenido de 1 y 0, lo va separando en un array de bytes
            int count_tmp =0;
            for(int a=0; a<(this.Longitud*8);a = a + 8){
                s[count_tmp]=tmp.substring(a, a + 8);                
                count_tmp++;
            }
            //llama a un procedimiento privado para reconstruir el mensaje
            mensaje_original = getMensajeToString(s);
        }//fin si
        return mensaje_original;
    }

    public BufferedImage getFoto(){
        return this.foto;
    }

   private String toBinary(byte caracter){
        byte byteDeCaracter = (byte)caracter;
        String binario="";
        for( int i = 7; i>=0; i--){
           binario = binario + ( ( ( byteDeCaracter & ( 1<<i ) ) > 0 ) ? "1" : "0" ) ;
        }
        return binario;
    }

    /* convierte un valor binario a caracter */
    private String toChar(String binario){
        int i = Integer.parseInt(binario ,2);
        String aChar = new Character((char)i).toString();
        return aChar;        
    }

    private int toCharInt(String binario){
        int i = Integer.parseInt(binario ,2);        
        return i;
    }

    /*  dado un mensaje en un STRING descompone este en un String con su
        equivalente en binario */
    private String getMensajeToBinary(String mensaje){
        String mb = "";
        char[] mensaje_tmp = mensaje.toCharArray();
        for(int i=0; i<mensaje_tmp.length;i++){
            mb = mb + toBinary( (byte) mensaje_tmp[i]);
        }
        return mb;
    }

    /* reconstruye el mensaje del array binario a un String */
    private String getMensajeToString(String[] mensaje){
        String mo ="";
        //lee a partir del 5 elemento ya que los cuatro primeros son la firma y la longitud del mensaje
        for(int i=4; i<mensaje.length;i++){
            mo = mo + toChar(mensaje[i]) ;
        }
        return mo;
    }

    /* reemplaza el bite menos significativo con un bits del mensaje */
    private String  ReemplazarLSB(String colorRGB){
        if(contador < mensaje_binario.length()){
            colorRGB = colorRGB.substring(0,7) + mensaje_binario.substring(contador, contador+1);
            contador++;    
        }
        return colorRGB;
    }

    private String getLSB(String binario){
        return binario.substring(7, 8);
    }

}
