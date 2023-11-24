package Entidades;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "tecnicos")
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
    @ManyToMany
    @JoinTable(
            name = "tecnicos_servicios",
            joinColumns = @JoinColumn(name = "id_tecnico"),
            inverseJoinColumns = @JoinColumn(name = "id_servicio"))
    private List<Servicio> competencias = new ArrayList<>();

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Servicio> getCompetencias() {
        return competencias;
    }

    public void setCompetencias(List<Servicio> competencias) {
        this.competencias = competencias;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos;
    }
}
