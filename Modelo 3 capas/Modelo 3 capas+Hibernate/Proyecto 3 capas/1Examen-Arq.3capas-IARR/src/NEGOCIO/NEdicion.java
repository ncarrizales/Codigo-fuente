/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package NEGOCIO;

import DATOS.Tema;
import DATOS.Curso;
import DATOS.Aula;
import DATOS.Edicion;
import DATOS.Empleado;
import java.sql.Date;

import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Isis Roman
 */
public class NEdicion {

     private Edicion edicion;
     private Curso curso;
     private Aula aula;
     private Empleado empleado;
     private Tema tema;

    public NEdicion() {
       edicion = new Edicion();
       curso = new Curso();
       tema =  new Tema();
       aula = new Aula();
       empleado = new Empleado();
    }
  //---------------------- METODOS-----------------------------------------//

    public Edicion getEdicion() {
        return edicion;
    }

    public void setEdicion(Edicion edicion) {
        this.edicion = edicion;
    }

    //------------------------------------------------------------------------------
    public void Insertar(String CODIGO, String FECHAINI,String FECHAFIN, Tema TEMA, Curso CURSO,Aula AULA, Empleado EMPLEADO ) {
       if (!Existe(CODIGO)) {
            getEdicion().setCodigo(CODIGO);
            Date d1 = Date.valueOf(FECHAINI);
            getEdicion().setFechaIni(d1);
            Date d2 = Date.valueOf(FECHAFIN);
            getEdicion().setFechaFin(d2);
            getEdicion().setTema(TEMA);
            getEdicion().setCurso(CURSO);
            getEdicion().setAula(AULA);
            getEdicion().setEmpleado(EMPLEADO);
            getEdicion().Insertar();

        } else {
            String txt = "EL CODIGO YA EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);

        }
    }
//------------------------------------------------------------------------------
    public void Modificar(String CODIGO, String FECHAINI,String FECHAFIN, Tema TEMA, Curso CURSO,Aula AULA, Empleado EMPLEADO ) {
       if (Existe(CODIGO)) {
            getEdicion().setCodigo(CODIGO);
            Date d1 = Date.valueOf(FECHAINI);
            getEdicion().setFechaIni(d1);
            Date d2 = Date.valueOf(FECHAFIN);
            getEdicion().setFechaFin(d2);
            getEdicion().setTema(TEMA);
            getEdicion().setCurso(CURSO);
            getEdicion().setAula(AULA);
            getEdicion().setEmpleado(EMPLEADO);
            getEdicion().Modificar();

        } else {
            String txt = "EL CODIGO NO EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);

        }
    }
//------------------------------------------------------------------------------
    public void Eliminar(String id) {
        if (Existe(id)) {
           getEdicion().getEdicion(id).Eliminar();
        } else {
            String txt = "EL CODIGO NO EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);

        }
    }
//------------------------------------------------------------------------------
    public boolean Existe(String id) {
        return getEdicion().Existe(id);
    }
//------------------------------------------------------------------------------
    public List ListarEdicion(){
       return getEdicion().getListEdicion();
    }
//------------------------------------------------------------------------------
    public Edicion ListarEdicion(String id){
         return getEdicion().getEdicion(id);
    }
 //------------------------------------------------------------------------------
    public void imprimir(){
         List r = ListarEdicion();
         System.out.println("CODIGO | FECHAINI | FECHAFIN | IDTEMA | IDCURSO | IDAULA | IDEMPLEADO");//
         System.out.print("--------------------");System.out.println();
         for (int i = 0; i < r.size(); i++) {
            Object[] x = (Object[]) r.get(i);
            System.out.print(""+x[0].toString()+", ");
            System.out.print(""+x[1].toString()+", ");
            System.out.print(""+x[2].toString()+", ");
            System.out.print(""+x[3].toString()+", ");
            System.out.print(""+x[4].toString()+", ");
            System.out.print(""+x[5].toString()+", ");
            System.out.println(""+x[6].toString());
        }
    }
//------------------------------------------------------------------------------

    public static void main(String args[]) {
      NEdicion a = new NEdicion();
     // a.Eliminar("A07");
     a.imprimir();
     //System.out.println(""+a.ListaAula().toString());

    }
//------------------------------------------------------------------------------


}
