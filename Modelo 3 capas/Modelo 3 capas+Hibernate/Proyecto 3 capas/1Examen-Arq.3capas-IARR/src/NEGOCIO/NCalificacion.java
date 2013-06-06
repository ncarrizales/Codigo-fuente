/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package NEGOCIO;

import DATOS.Calificacion;
import DATOS.Edicion;
import DATOS.Empleado;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Isis Roman
 */

public class NCalificacion {

    private Calificacion nota;
    private Empleado empleado;
    private Edicion edicion;

    public NCalificacion() {
        nota =  new Calificacion();
        empleado = new Empleado();
        edicion = new Edicion();
    }

    public Calificacion getNota() {
        return nota;
    }

    public void setNota(Calificacion nota) {
        this.nota = nota;
    }

  //---------------------- METODOS-----------------------------------------//
  //------------------------------------------------------------------------------
    public void Insertar(Empleado EMPLEADO, Edicion EDICION, int NOTA) {

       if (!Existe(EMPLEADO.getCodigo())) {
            getNota().setEmpleado(EMPLEADO);
            getNota().setEdicion(EDICION);
            getNota().setNota(NOTA);
            getNota().Insertar();

        } else {
            String txt = "EL CODIGO YA EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);
        }
    }
//------------------------------------------------------------------------------
    public void Modificar(Empleado EMPLEADO, Edicion EDICION, int NOTA) {

       if (Existe(EMPLEADO.getCodigo())) {
            getNota().setEmpleado(EMPLEADO);
            getNota().setEdicion(EDICION);
            getNota().setNota(NOTA);
            getNota().Modificar();

        } else {
            String txt = "EL CODIGO NO EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);

        }
    }
//------------------------------------------------------------------------------
    public void Eliminar(String id) {
        if (Existe(id)) {
            getNota().getCalificacion(id).Eliminar();
        } else {
            String txt = "EL CODIGO NO EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);
        }
    }
//------------------------------------------------------------------------------
    public boolean Existe(String id) {
        return getNota().Existe(id);
    }
//------------------------------------------------------------------------------
    public List ListarCalificacion(){
       return getNota().getListCalificacion();
    }
//------------------------------------------------------------------------------
    public Calificacion ListarCalificacion(String id){
         return getNota().getCalificacion(id);
    }
    //------------------------------------------------------------------------------
    public void imprimir(){
         List r = ListarCalificacion();
         System.out.println("IDEMPLEADO | IDEDICION | NOTA ");//
         System.out.print("--------------------");System.out.println();
         for (int i = 0; i < r.size(); i++) {
            Object[] x = (Object[]) r.get(i);
            System.out.print(""+x[0].toString()+", ");
            System.out.print(""+x[1].toString()+", ");
            System.out.println(""+x[2].toString());
        }
    }
//------------------------------------------------------------------------------
    public List getCalificacion(String id){
       return getNota().getListCalificacion(id);
    }
//------------------------------------------------------------------------------
    public static void main(String args[]) {
      NCalificacion a = new NCalificacion();
       // a.Eliminar("A07");
      a.imprimir();
     //System.out.println(""+a.ListaAula().toString());
    }
//------------------------------------------------------------------------------


}
