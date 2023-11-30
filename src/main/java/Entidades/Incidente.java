package Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
@Entity
@Table(name = "incidentes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "observaciones")
    private String observaciones;
}
