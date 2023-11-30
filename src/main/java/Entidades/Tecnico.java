package Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "tecnicos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tecnico")
    private int idTecnico;
    @Column(name = "dni_tecnico")
    private int dni;
    @Column(name = "nombre_tecnico", length = 32)
    private String nombre;
    @Column(name = "apellidos_tecnico",length = 64)
    private String apellidos;
    @Column(name = "telefono_tecnico",length = 15)
    private String telefono;
    @Column(name = "email_tecnico",length = 32)
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tecnicos_servicios",
            joinColumns = @JoinColumn(name = "id_tecnico"),
            inverseJoinColumns = @JoinColumn(name = "id_servicio"))
    private List<Servicio> competencias = new ArrayList<>();
    @Override
    public String toString() {
        return nombre + " " + apellidos;
    }
}
