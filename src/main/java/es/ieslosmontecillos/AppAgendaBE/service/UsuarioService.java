package es.ieslosmontecillos.AppAgendaBE.service;

import es.ieslosmontecillos.AppAgendaBE.entity.Usuario;

import java.io.Serializable;
import java.util.List;
public interface UsuarioService extends Serializable {
    List<Usuario> findAll();
    Usuario save(Usuario usuario);
    Usuario findByUsuario(String usuario);
    void delete(Usuario usuario);
}
