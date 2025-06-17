package es.ieslosmontecillos.AppAgendaBE.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="USUARIOS")
public class Usuario implements Serializable {
    @Id
    @Column(name = "USUARIO", nullable = false, length = 20,unique = true)
    private String usuario;

    @Basic
    @Column(name = "CONTRASENA", nullable = false, length = 20)
    private String contrasena;

    @Basic
    @Column(name = "TIPO", nullable = false)
    private char tipo;

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public char getTipo() {
        return tipo;
    }
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return  Objects.equals(usuario, usuario.usuario) &&
                Objects.equals(contrasena, usuario.contrasena ) && Objects.equals(tipo, usuario.tipo);
    }
    @Override
    public int hashCode() {
        return Objects.hash(usuario, contrasena,tipo);
    }
}
