/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package NEGOCIO;

import DATOS.Tema;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Isis Roman
 */
public class NTema {

  private Tema tema;

    public NTema() {
        tema = new Tema();
    }

  //---------------------- METODOS-----------------------------------------//
    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }
  //------------------------------------------------------------------------------
    public void Insertar(String IDTEMA, String TEMA) {
       if (!Existe(IDTEMA)) {
            getTema().setIdtema(IDTEMA);
            getTema().setTema(TEMA);
            getTema().Insertar();

        } else {
            String txt = "EL CODIGO YA EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);

        }
    }
//------------------------------------------------------------------------------
    public void Modificar(String IDTEMA, String TEMA) {
       if (Existe(IDTEMA)) {
            getTema().setIdtema(IDTEMA);
            getTema().setTema(TEMA);
            getTema().Modificar();

        } else {
            String txt = "EL CODIGO NO EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);

        }
    }
//------------------------------------------------------------------------------
    public void Eliminar(String id) {
         if (Existe(id)) {
           getTema().getTema(id).Eliminar();
        }else {
            String txt = "EL CODIGO NO EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);

        }
    }
//------------------------------------------------------------------------------
    public boolean Existe(String id) {
        return getTema().Existe(id);
    }
//------------------------------------------------------------------------------
    public List ListarTema(){
       return getTema().getListTema();
    }
//------------------------------------------------------------------------------
    public Tema ListarTema(String id){
         return getTema().getTema(id);
    }
    //------------------------------------------------------------------------------
    public void imprimir(){
         List r = ListarTema();
         System.out.println("IDTEMA | TEMA");//
         System.out.print("--------------------");System.out.println();
         for (int i = 0; i < r.size(); i++) {
            Object[] x = (Object[]) r.get(i);
            System.out.print(""+x[0].toString()+", ");
            System.out.println(" "+x[1].toString());
        }
    }
//------------------------------------------------------------------------------
    public static void main(String args[]) {
      NTema a = new NTema();
     // a.Eliminar("A07");
      a.imprimir();
     //System.out.println(""+a.ListaAula().toString());

    }
//------------------------------------------------------------------------------


 
}
