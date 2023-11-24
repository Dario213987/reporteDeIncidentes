package Pantallas.Elementos;

import Entidades.Incidente;

import javax.swing.table.AbstractTableModel;
import java.time.Duration;
import java.util.List;


public class TablaIncidentes extends AbstractTableModel {
    List<Incidente> incidentes;
    String[] columnas = new String[]{"ID","Fecha","Servicio","Cliente","Técnico Asignado","Estado","Tiempo Estimado",};
    public TablaIncidentes(List<Incidente> incidentes) {
        this.incidentes = incidentes;
    }
    @Override
    public int getRowCount() {
        return incidentes.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }
    @Override
    public String getColumnName(int columna) {
        return columnas[columna];
    }
    public Incidente getIncidente(int fila){
        return incidentes.get(fila);
    }
    @Override
    public Object getValueAt(int i, int j) {
        return switch (j) {
            case 0 -> incidentes.get(i).getIdIncidente();
            case 1 -> incidentes.get(i).getFecha();
            case 2 -> incidentes.get(i).getServicio();
            case 3 -> incidentes.get(i).getCliente();
            case 4 -> incidentes.get(i).getTecnicoAsignado();
            case 5 -> incidentes.get(i).isEstado();
            case 6 -> Duration.ofMillis(
                    incidentes.get(i).getTiempoEstimado()
            ).toHours() + "hs";
            default -> null;
        };
    }
}
