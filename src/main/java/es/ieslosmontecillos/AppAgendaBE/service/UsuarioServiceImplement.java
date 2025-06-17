package es.ieslosmontecillos.AppAgendaBE.service;

import es.ieslosmontecillos.AppAgendaBE.Dao.UsuarioDao;
import es.ieslosmontecillos.AppAgendaBE.entity.Provincia;
import es.ieslosmontecillos.AppAgendaBE.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UsuarioServiceImplement implements UsuarioService {
    @Autowired
    private UsuarioDao usuarioDao;
    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }
    @Override
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }
    @Override
    public Usuario findByUsuario(String usuario) {
        return usuarioDao.findById(usuario).orElse(null);
    }
    @Override
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }
}

