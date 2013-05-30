/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package NEGOCIO;

import DATOS.Empleado;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Isis Roman
 */
public class NEmpleado {

     private Empleado empleado;

    public NEmpleado() {
        empleado = new Empleado();
    }


  //---------------------- METODOS-----------------------------------------//

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    //------------------------------------------------------------------------------
    public void Insertar(String CODIGO, int CI, String NOMBRE, String FECHAINGRESO, String CARGO) {
        if (!Existe(CODIGO)) {
            getEmpleado().setCodigo(CODIGO);
            getEmpleado().setCi(CI);
            getEmpleado().setNombre(NOMBRE);
            Date fecha = Date.valueOf(FECHAINGRESO);
            getEmpleado().setFechaIngreso(fecha);
            getEmpleado().setCargo(CARGO);
            getEmpleado().Insertar();

        } else {
            String txt = "EL CODIGO YA EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);

        }
    }
//------------------------------------------------------------------------------
    public void Modificar(String CODIGO, int CI, String NOMBRE, String FECHAINGRESO, String CARGO) {
        if (Existe(CODIGO)) {
            getEmpleado().setCodigo(CODIGO);
            getEmpleado().setCi(CI);
            getEmpleado().setNombre(NOMBRE);
             Date fecha = Date.valueOf(FECHAINGRESO);
            getEmpleado().setFechaIngreso(fecha);
            getEmpleado().setCargo(CARGO);
            getEmpleado().Modificar();

        } else {
            String txt = "EL CODIGO NO EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);

        }
    }
//------------------------------------------------------------------------------
    public void Eliminar(String id) {
        if (Existe(id)) {
            getEmpleado().getEmpleado(id).Eliminar();
        } else {
            String txt = "EL CODIGO NO EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);

        }
    }
//------------------------------------------------------------------------------
    public boolean Existe(String id) {
        return getEmpleado().Existe(id);

    }
//------------------------------------------------------------------------------
    public List ListarEmpleado(){
       return getEmpleado().getListEmpleado();
    }
//------------------------------------------------------------------------------
    public Empleado ListarEmpleado(String id){
         return getEmpleado().getEmpleado(id);
    }
   //------------------------------------------------------------------------------
    public void imprimir(){
         List r = ListarEmpleado();
         System.out.println("CODIGO | CI | NOMBRE | FECHAINGRESO | CARGO");//
         System.out.print("--------------------");System.out.println();
         for (int i = 0; i < r.size(); i++) {
            Object[] x = (Object[]) r.get(i);
            System.out.print(""+x[0].toString()+", ");
            System.out.print(""+x[1].toString()+", ");
            System.out.print(""+x[2].toString()+", ");
            System.out.print(""+x[3].toString()+", ");
            System.out.println(""+x[4].toString());
        }
    }
//------------------------------------------------------------------------------

    public static void main(String args[]) {
      NEmpleado a = new NEmpleado();
      a.imprimir();
      a.Insertar("E05", 6296970 , "Isabel Rodriguez ", "28-08-2011", "Ing. Informatica");
      a.imprimir();
     // a.Eliminar("A07");

    }
//------------------------------------------------------------------------------
}
