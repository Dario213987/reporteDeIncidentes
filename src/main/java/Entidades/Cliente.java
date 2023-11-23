package Entidades;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int idCliente;
    @Column(name = "razon_social_cliente", length = 64)
    private String razonSocial;
    @Column(name = "cuit_cliente")
    private int cuit;
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
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

    public List<Servicio> getServiciosContratados() {
        return serviciosContratados;
    }

    public void setServiciosContratados(List<Servicio> serviciosContratados) {
        this.serviciosContratados = serviciosContratados;
    }

    public List<Incidente> getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(List<Incidente> incidentes) {
        this.incidentes = incidentes;
    }

    public void addServicioContratado(Servicio servicio){
        serviciosContratados.add(servicio);
    }
    public void addIncidente(Incidente incidente){
        incidentes.add(incidente);
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                "\n, razonSocial='" + razonSocial + '\'' +
                "\n, cuit=" + cuit +
                "\n, telefono='" + telefono + '\'' +
                "\n, email='" + email + '\'' +
                "\n, serviciosContratados=" + serviciosContratados +
                "\n, incidentes=" + incidentes +
                '}';
    }
}
