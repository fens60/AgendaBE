package es.ieslosmontecillos.AppAgendaBE.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Basic
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Basic
    @Column(name = "APELLIDOS", nullable = false)
    private String apellidos;

    @Basic
    @Column(name = "TELEFONO", nullable = true)
    private String telefono;

    @Basic
    @Column(name = "EMAIL", nullable = true)
    private String email;


    @ManyToOne
    @JoinColumn(name = "PROVINCIA", nullable = false)
    private Provincia provincia;

    @Basic
    @Column(name = "FECHANACIMIENTO", nullable = false)
    private Date fechaNacimiento;

    @Basic
    @Column(name = "NUM_HIJOS", nullable = true)
    private short numHijos;

    @Basic
    @Column(name = "ESTADO_CIVIL")
    private char estadoCivil;

    @Basic
    @Column(name = "SALARIO")
    private BigDecimal salario;

    @Basic
    @Column(name = "JUBILADO")
    private Byte jubilado;

    @Basic
    @Column(name = "FOTO")
    private String foto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;

        return Objects.equals(id, cliente.id) && Objects.equals(email, cliente.email) &&
                Objects.equals(fechaNacimiento, cliente.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, fechaNacimiento);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Date getFecha() {
        return fechaNacimiento;
    }

    public void setFecha(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public short getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(short numHijos) {
        this.numHijos = numHijos;
    }

    public char getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(char estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Byte getJubilado() {
        return jubilado;
    }

    public void setJubilado(Byte jubilado) {
        this.jubilado = jubilado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
