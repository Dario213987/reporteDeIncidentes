package Pantallas.Elementos;

import Entidades.Servicio;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablaServicios extends AbstractTableModel {
    List<Servicio> servicios;
    String[] columnas = new String[]{"ID","Nombre"};
    public TablaServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
    @Override
    public int getRowCount() {
        return servicios.size();
    }
    @Override
    public int getColumnCount() {
        return columnas.length;
    }
    @Override
    public String getColumnName(int columna) {
        return columnas[columna];
    }
    public Servicio getIncidente(int fila){
        return servicios.get(fila);
    }
    @Override
    public Object getValueAt(int i, int j) {
        return switch (j) {
            case 0 -> servicios.get(i).getIdServicio();
            case 1 -> servicios.get(i).getNombre();
            default -> null;
        };
    }
}
