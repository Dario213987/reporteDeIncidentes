package Pantallas.Elementos;

import Entidades.Incidente;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
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
    public List<Incidente> getIncidentes(int[] filas){
        List<Incidente> listaSeleccionada = new ArrayList<>();
        for (int n: filas){listaSeleccionada.add(incidentes.get(n));}
        return listaSeleccionada;
    }
    public void agregarIncidente(Incidente nuevoIncidente) {
        incidentes.add(nuevoIncidente);
        int nuevaFila = incidentes.size() - 1;
        fireTableRowsInserted(nuevaFila, nuevaFila);
    }
    public void eliminarIncidente(Incidente incidente) {
        int filaEliminada = incidentes.indexOf(incidente);
        incidentes.remove(incidente);
        fireTableRowsDeleted(filaEliminada, filaEliminada);
    }
    public void eliminarIncidentes(List<Incidente> incidentes){
        incidentes.forEach(this::eliminarIncidente);
    }
    @Override
    public Object getValueAt(int i, int j) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return switch (j) {
            case 0 -> incidentes.get(i).getIdIncidente();
            case 1 -> df.format(incidentes.get(i).getFecha());
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
