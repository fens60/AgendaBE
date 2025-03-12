package es.ieslosmontecillos.AppAgendaBE.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
@Entity
@Table(name = "LOGIN")
public class Login implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;
    @Basic
    @Column(name = "EMAIL", nullable = true, length = 100)
    private String email;
    @Basic
    @Column(name = "CLAVE", nullable = false, length = 255)
    private String clave;
    @Basic
    @Column(name = "VIGENCIA", nullable = false)
    private Boolean vigencia;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String usuario) {
        this.email = email;
    }
    public Boolean getVigencia() {
        return vigencia;
    }
    public void setVigencia(Boolean vigencia) {
        this.vigencia = vigencia;
    }

    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return id == login.id && Objects.equals(email, login.email) &&
                Objects.equals(clave, login.clave);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, email, clave);
    }
}