package Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int idCliente;
    @Column(name = "razon_social_cliente", length = 64)
    private String razonSocial;
    @Column(name = "cuit_cliente")
    private String cuit;
    @Column(name = "telefono_cliente",length = 15)
    private String telefono;
    @Column(name = "email_cliente",length = 32)
    private String email;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "clientes_servicios",
            joinColumns = @JoinColumn(name = "id_cliente"),
            inverseJoinColumns = @JoinColumn(name = "id_servicio"))
    private List<Servicio> serviciosContratados = new ArrayList<>();
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Incidente> incidentes = new ArrayList<>();
    public void addServicioContratado(Servicio servicio){
        serviciosContratados.add(servicio);
    }
    public void addIncidente(Incidente incidente){
        incidentes.add(incidente);
    }


    @Override
    public String toString() {
        return razonSocial;
    }
}
