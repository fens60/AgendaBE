package es.ieslosmontecillos.AppAgendaBE.service;

import es.ieslosmontecillos.AppAgendaBE.Dao.LoginDao;
import es.ieslosmontecillos.AppAgendaBE.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImplement implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public List<Login> findAll() {
        return loginDao.findAll();
    }
    @Override
    public Login save(Login login) {
        return loginDao.save(login);
    }

    @Override
    public Login findById(Long id) {
        return loginDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Login login) {
        loginDao.delete(login);
    }


}