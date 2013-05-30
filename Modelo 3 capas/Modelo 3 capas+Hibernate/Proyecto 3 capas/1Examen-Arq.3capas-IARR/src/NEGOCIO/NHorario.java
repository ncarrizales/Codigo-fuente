/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package NEGOCIO;

import DATOS.Horario;
import DATOS.Edicion;
import java.sql.Time;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Isis Roman
 */
public class NHorario {

    private Horario horario;
    private Edicion edicion;

    public NHorario() {
         horario = new Horario();
         edicion = new Edicion();
    }
  //---------------------- METODOS-----------------------------------------//
    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
  //------------------------------------------------------------------------------
    public void Insertar(int IDHORA, String DIAS, String HORAINI, String HORAFIN,  Edicion EDICION) {

      // if (!Existe(IDHORA) ){
            getHorario().setIdhora(0);
            getHorario().setDias(DIAS);
            Time t1 = Time.valueOf(HORAINI);
            getHorario().setHoraIni(t1);
            Time t2 = Time.valueOf(HORAFIN);
            getHorario().setHoraFin(t2);
            getHorario().setEdicion(edicion);
            getHorario().Insertar();

        /*} else {
            String txt = "EL CODIGO YA EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);
        }*/
    }
//------------------------------------------------------------------------------
    public void Modificar(int IDHORA, String DIAS, String HORAINI, String HORAFIN,  Edicion EDICION) {

       if (Existe(IDHORA) ){
            getHorario().setIdhora(IDHORA);
            getHorario().setDias(DIAS);
             Time t1 = Time.valueOf(HORAINI);
            getHorario().setHoraIni(t1);
             Time t2 = Time.valueOf(HORAFIN);
            getHorario().setHoraFin(t2);
            getHorario().setEdicion(edicion);
            getHorario().Modificar();

        } else {
            String txt = "EL CODIGO NO EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);

        }
    }
//------------------------------------------------------------------------------
    public void Eliminar(int id) {
        if (Existe(id)) {
            getHorario().getHorario(id).Eliminar();
        } else {
            String txt = "EL CODIGO NO EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);
        }
    }
//------------------------------------------------------------------------------
    public boolean Existe(int id) {
        return getHorario().Existe(id);
    }
//------------------------------------------------------------------------------
    public List ListarHorario(){
       return getHorario().getListHorario();
    }
//------------------------------------------------------------------------------
    public Horario ListarHorario(int id){
         return getHorario().getHorario(id);
    }
    public Horario getIdHorario(String id){
         return getHorario().getIdHorario(id);
    }
    //------------------------------------------------------------------------------
    public void imprimir(){
         List r = ListarHorario();
         System.out.println("IDHORA | DIAS | HORAINI | HORAFIN | IDEDICION ");//
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
      NHorario a = new NHorario();
       // a.Eliminar("A07");
      a.imprimir();
     //System.out.println(""+a.ListaAula().toString());
    }
//------------------------------------------------------------------------------





}

