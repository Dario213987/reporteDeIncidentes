package Pantallas.Elementos;

import Entidades.Tecnico;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablaTecnico extends AbstractTableModel {
    List<Tecnico> tecnicos;
    String[] columnas = new String[]{"ID", "DNI", "Nombre y Apellido", "Télefono", "Correo Electrónico"};
    public TablaTecnico(List<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }
    @Override
    public int getRowCount() {
        return tecnicos.size();
    }
    @Override
    public int getColumnCount() {
        return columnas.length;
    }
    @Override
    public String getColumnName(int columna) {
        return columnas[columna];
    }
    public Tecnico getIncidente(int fila){
        return tecnicos.get(fila);
    }
    @Override
    public Object getValueAt(int i, int j) {
        return switch (j) {
            case 0 -> tecnicos.get(i).getIdTecnico();
            case 1 -> tecnicos.get(i).getDni();
            case 2 -> tecnicos.get(i).getNombre() + " " + tecnicos.get(i).getApellidos();
            case 3 -> tecnicos.get(i).getTelefono();
            case 4 -> tecnicos.get(i).getEmail();
            default -> null;
        };
    }
}
