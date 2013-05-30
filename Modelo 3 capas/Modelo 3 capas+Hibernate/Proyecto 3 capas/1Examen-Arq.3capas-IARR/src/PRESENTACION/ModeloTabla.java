/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PRESENTACION;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Isis Roman
 */
public class ModeloTabla extends AbstractTableModel{

    private String nombreColumna[];
    private ArrayList<Object[]> contenedor;

    public ModeloTabla(String nombreCol[],ArrayList<Object[]> datos) {
        nombreColumna=nombreCol;
        contenedor=datos;
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumna[column];
    }

    public void setContenedor(ArrayList<Object[]> contenedor) {
        this.contenedor = contenedor;
        update();
    }

    public int getRowCount() {
        return contenedor.size();
    }

    public int getColumnCount() {
        return nombreColumna.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return contenedor.get(rowIndex)[columnIndex];
    }

    public Object getId(int rowIndex){
        return contenedor.get(rowIndex)[nombreColumna.length];
    }

    public void update(){
        super.fireTableDataChanged();
    }

}
