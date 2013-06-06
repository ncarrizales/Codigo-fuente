/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package NEGOCIO;

import DATOS.Inscripcion;
import DATOS.Edicion;
import DATOS.Empleado;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Isis Roman
 */
public class NInscripcion {

    private Inscripcion inscripcion;
    private Edicion edicion;
    private Empleado empleado;

    public NInscripcion() {
        inscripcion = new Inscripcion();
        edicion = new Edicion();
        empleado = new Empleado();
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

  //---------------------- METODOS-----------------------------------------//

//------------------------------------------------------------------------------
 public void Insertar(int CODIGO , String DESCRIPCION, String FECHA , Edicion EDICION, Empleado EMPLEADO) {
       if (!Existe(CODIGO)) {
            getInscripcion().setCodigo(CODIGO);
            getInscripcion().setDescripcion(DESCRIPCION);
            Date fecha = Date.valueOf(FECHA);
            getInscripcion().setFecha(fecha);
            getInscripcion().setEdicion(EDICION);
            getInscripcion().setEmpleado(EMPLEADO);
            getInscripcion().Insertar();
        } else {
            String txt = "EL CODIGO YA EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);

        }
    }
//------------------------------------------------------------------------------
    public void Modificar(int CODIGO , String DESCRIPCION, String FECHA , Edicion EDICION, Empleado EMPLEADO) {
       if (Existe(CODIGO)) {
            getInscripcion().setCodigo(CODIGO);
            getInscripcion().setDescripcion(DESCRIPCION);
            Date fecha = Date.valueOf(FECHA);
            getInscripcion().setFecha(fecha);
            getInscripcion().setEdicion(EDICION);
            getInscripcion().setEmpleado(EMPLEADO);
            getInscripcion().Modificar();

        } else {
            String txt = "EL CODIGO NO EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);

        }
    }
//------------------------------------------------------------------------------
    public void Eliminar(int id) {
        if (Existe(id)) {
            getInscripcion().getInscripcion(id).Eliminar();
        } else {
            String txt = "EL CODIGO NO EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);

        }
    }
//------------------------------------------------------------------------------
    public boolean Existe(int id) {
        return getInscripcion().Existe(id);
    }
//------------------------------------------------------------------------------
    public List ListarInscripcion(){
       return getInscripcion().getListInscripcion();
    }
//------------------------------------------------------------------------------
    public Inscripcion ListarInscripcion(int id){
         return getInscripcion().getInscripcion(id);
    }
//------------------------------------------------------------------------------
    public void imprimir(){
         List r = ListarInscripcion();
         System.out.println("CODIGO | DESCRIPCION | FECHA | IDEDICION | IDEMPLEADO ");//
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
      NInscripcion a = new NInscripcion();
     // a.Eliminar("A07");
     a.imprimir();
     //System.out.println(""+a.ListaAula().toString());

    }
//------------------------------------------------------------------------------

}
