package Entidades;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
@Entity
@Table(name = "incidentes")
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incidente")
    private int idIncidente;
    @Column(name = "fecha_incidente")
    private Date fecha;
    @ManyToOne
    @JoinColumn(name = "cliente_incidente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "servicio_incidente")
    private Servicio servicio;
    @ManyToOne
    @JoinColumn(name = "tecnico_incidente")
    private Tecnico tecnicoAsignado;
    @Column(name = "estado_incidente")
    private boolean estado;
    @Column(name = "tiempo_estimado_incidente")
    private long tiempoEstimado;

    public int getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(int idIncidente) {
        this.idIncidente = idIncidente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Tecnico getTecnicoAsignado() {
        return tecnicoAsignado;
    }

    public void setTecnicoAsignado(Tecnico tecnicoAsignado) {
        this.tecnicoAsignado = tecnicoAsignado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public long getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(long tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }
}
