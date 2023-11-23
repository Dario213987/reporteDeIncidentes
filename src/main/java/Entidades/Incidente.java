package Entidades;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.List;
@Entity
@Table(name = "incidentes")
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incidente")
    private int idIncidente;
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
}
