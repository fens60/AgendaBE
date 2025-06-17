package es.ieslosmontecillos.AppAgendaBE.Dao;

import es.ieslosmontecillos.AppAgendaBE.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao  extends JpaRepository<Usuario, String>{

}
