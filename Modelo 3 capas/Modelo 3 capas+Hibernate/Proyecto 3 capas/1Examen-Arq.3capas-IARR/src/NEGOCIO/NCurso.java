/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package NEGOCIO;

import DATOS.Curso;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Isis Roman
 */
public class NCurso {

    private Curso curso;
    public NCurso() {
        curso = new Curso();
    }
//---------------------- METODOS-----------------------------------------//
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    //------------------------------------------------------------------------------
    public void Insertar(String IDCURSO, String TITULO, int NUMHORAS) {

       if (!Existe(IDCURSO)) {
            getCurso().setIdcurso(IDCURSO);
            getCurso().setTitulo(TITULO);
            getCurso().setNumeroHoras(NUMHORAS);
            getCurso().Insertar();
            /*if(!PRE_REQUISITO.isEmpty()){
                 requisitos.setCurso(getCurso().getCurso(IDCURSO));
                 requisitos.setPre_requisito(getCurso().getCurso(PRE_REQUISITO));
                 requisitos.Insertar();
            }*/
         
        } else {
            String txt = "EL CODIGO YA EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);
        }
    }
//------------------------------------------------------------------------------
    public void Modificar(String IDCURSO, String TITULO, int NUMHORAS) {

       if (Existe(IDCURSO)) {
            getCurso().setIdcurso(IDCURSO);
            getCurso().setTitulo(TITULO);
            getCurso().setNumeroHoras(NUMHORAS);
            getCurso().Modificar();
            

        } else {
            String txt = "EL CODIGO NO EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);

        }
    }
//------------------------------------------------------------------------------
    public void Eliminar(String id) {
        if (Existe(id)) {
            getCurso().getCurso(id).Eliminar();
        } else {
            String txt = "EL CODIGO NO EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);
        }
    }
//------------------------------------------------------------------------------
    public boolean Existe(String id) {
        return getCurso().Existe(id);
    }
//------------------------------------------------------------------------------
    public List ListarCurso(){
       return getCurso().getListCurso();
    }

//------------------------------------------------------------------------------
    public Curso ListarCurso(String id){
         return getCurso().getCurso(id);
    }
//------------------------------------------------------------------------------

    //------------------------------------------------------------------------------
    public void imprimir(){
         List r = ListarCurso();
         System.out.println("IDCURSO | TITULO | NUMHORAS ");//
         System.out.print("--------------------");System.out.println();
         for (int i = 0; i < r.size(); i++) {
            Object[] x = (Object[]) r.get(i);
            System.out.print(""+x[0].toString()+", ");
            System.out.print(""+x[1].toString()+", ");
            System.out.println(""+x[2].toString());
        }
    }
//------------------------------------------------------------------------------

    public static void main(String args[]) {
      NCurso a = new NCurso();
       // a.Eliminar("A07");
      a.imprimir();
     //System.out.println(""+a.ListaAula().toString());
    }
//------------------------------------------------------------------------------


}
