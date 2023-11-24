package Pantallas.Elementos;

import Entidades.Cliente;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablaClientes extends AbstractTableModel {
    List<Cliente> clientes;
    String[] columnas = new String[]{"ID","Razón Social","CUIT","Télefono","Correo Electrónico"};
    public TablaClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    @Override
    public int getRowCount() {
        return clientes.size();
    }
    @Override
    public int getColumnCount() {
        return columnas.length;
    }
    @Override
    public String getColumnName(int columna) {
        return columnas[columna];
    }
    public Cliente getIncidente(int fila){
        return clientes.get(fila);
    }
    @Override
    public Object getValueAt(int i, int j) {
        return switch (j) {
            case 0 -> clientes.get(i).getIdCliente();
            case 1 -> clientes.get(i).getRazonSocial();
            case 2 -> clientes.get(i).getCuit();
            case 3 -> clientes.get(i).getTelefono();
            case 4 -> clientes.get(i).getEmail();
            default -> null;
        };
    }
}
