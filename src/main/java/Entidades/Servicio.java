package Entidades;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "servicios")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private int idServicio;
    @Column(name = "nombre_servicio",length = 32)
    private String nombre;
    @ManyToMany(mappedBy = "serviciosContratados", cascade = CascadeType.ALL)
    private List<Cliente> clientes = new ArrayList<>();

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addCliente(Cliente cliente){
        clientes.add(cliente);
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "idServicio=" + idServicio +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}