/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package NEGOCIO;

import DATOS.Curso;
import DATOS.Requisitos;
import DATOS.RequisitosId;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Isis Roman
 */
public class NRequisitos {

    private Requisitos requisito;

    public NRequisitos() {
        requisito = new Requisitos();
    }

    public Requisitos getRequisito() {
        return requisito;
    }

    public void setRequisito(Requisitos requisito) {
        this.requisito = requisito;
    }

     //------------------------------------------------------------------------------
    public void Insertar(Curso IDCURSO, Curso REQUISITO) {

       if (!Existe(IDCURSO.getIdcurso()) ){
             getRequisito().setCurso(IDCURSO);
             getRequisito().setPre_requisito(REQUISITO);
             getRequisito().getId().setIdcurso(IDCURSO.getIdcurso());
             getRequisito().getId().setPre_requisito(REQUISITO.getIdcurso());
             getRequisito().Insertar();

        } else {
            String txt = "EL CODIGO YA EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);
        }
    }
//------------------------------------------------------------------------------
    public void Modificar(Curso IDCURSO, Curso REQUISITO) {

       if (Existe(IDCURSO.getIdcurso()) ){
             getRequisito().setCurso(IDCURSO);
             getRequisito().setPre_requisito(REQUISITO);
             getRequisito().Modificar();

        } else {
            String txt = "EL CODIGO NO EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);

        }
    }
//------------------------------------------------------------------------------
    public void Eliminar(String id) {
        if (Existe(id)) {
            getRequisito().Eliminar();
         
        } else {
            String txt = "EL CODIGO NO EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);
        }
    }
//------------------------------------------------------------------------------
    public boolean Existe(String id) {
        return getRequisito().Existe(id);
    }
//------------------------------------------------------------------------------
    public List ListarRequisitos(){
       return getRequisito().getListRequisitos();
    }
//------------------------------------------------------------------------------
    public RequisitosId ListarRequisito(String id){
         return getRequisito().getRequisitos(id);
    }
    //------------------------------------------------------------------------------
    public void imprimir(){
         List r = ListarRequisitos();
         System.out.println("IDCURSO | PRE-REQUISITO");//
         System.out.print("--------------------");System.out.println();
         for (int i = 0; i < r.size(); i++) {
            Object[] x = (Object[]) r.get(i);
            System.out.println();
            System.out.print(""+x[0].toString()+", ");
            System.out.println(""+x[1].toString());
        }
         
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
    public static void main(String args[]) {
      NRequisitos a = new NRequisitos();
     // a.Eliminar("A07");
     a.imprimir();
     

    }
//------------------------------------------------------------------------------

//------------------------------------------------------------------------------




}
