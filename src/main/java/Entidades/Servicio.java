package Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "servicios")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private int idServicio;
    @Column(name = "nombre_servicio",length = 32)
    private String nombre;
    @ManyToMany(mappedBy = "serviciosContratados", cascade = CascadeType.ALL)
    private List<Cliente> clientes = new ArrayList<>();
    @ManyToMany(mappedBy = "competencias",fetch = FetchType.EAGER)
    private List<Tecnico> tecnicosCapacitados = new ArrayList<>();
    public void addTecnicosCapacitados(Tecnico tecnicoCapacitado) {
        tecnicosCapacitados.add(tecnicoCapacitado);
    }
    public void addCliente(Cliente cliente){
        clientes.add(cliente);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
