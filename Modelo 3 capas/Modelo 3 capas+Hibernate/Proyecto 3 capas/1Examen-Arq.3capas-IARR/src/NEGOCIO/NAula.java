/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import DATOS.Aula;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Isis Roman
 */
public class NAula {

    private Aula aula;

    public NAula() {
        aula = new Aula();
    }

    //---------------------- METODOS-----------------------------------------//
    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }
//------------------------------------------------------------------------------
    public void Insertar(String IDAULA, int CAPACIDAD) {
       if (!Existe(IDAULA)) {
            getAula().setIdaula(IDAULA);
            getAula().setCapacidad(CAPACIDAD);

            getAula().Insertar();
            
        } else {
            String txt = "EL CODIGO YA EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);

        }
    }
//------------------------------------------------------------------------------
    public void Modificar(String IDAULA, int CAPACIDAD) {
        if (Existe(IDAULA)) {
            getAula().setIdaula(IDAULA);
            getAula().setCapacidad(CAPACIDAD);
            getAula().Modificar();
         
        } else {
            String txt = "EL CODIGO NO EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);

        }
    }
//------------------------------------------------------------------------------
    public void Eliminar(String id) {
        if (Existe(id)) {
            getAula().getAula(id).Eliminar();
        } else {
            String txt = "EL CODIGO NO EXISTE EN LA BASE DE DATOS!! \n\r"
                    + "POR FAVOR VERIQUE LOS DATOS E INTENTE NUEVAMENTE \n\r ";
            JOptionPane.showMessageDialog(null, txt, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE, null);

        }
    }
//------------------------------------------------------------------------------
    public boolean Existe(String id) {
        return getAula().Existe(id);
    }
//------------------------------------------------------------------------------
    public List ListarAula(){
       return getAula().getListAula();
    }
//------------------------------------------------------------------------------
    public Aula ListarAula(String id){
         return getAula().getAula(id);
    }
//------------------------------------------------------------------------------
    public void imprimir(){
         List r = ListarAula();
         System.out.println("IDAULA | CAPACIDAD ");//
         System.out.print("--------------------");System.out.println();
         for (int i = 0; i < r.size(); i++) {
            Object[] x = (Object[]) r.get(i);
            System.out.print(""+x[0].toString()+", ");
            System.out.println(""+x[1].toString());
        }
    }
//------------------------------------------------------------------------------
    public static void main(String args[]) {
      NAula a = new NAula();
     // a.Eliminar("A07");
     //a.imprimir();
     //System.out.println(""+a.ListaAula().toString());

    }
//------------------------------------------------------------------------------
}
