package es.ieslosmontecillos.AppAgendaBE.service;

import es.ieslosmontecillos.AppAgendaBE.entity.Login;

import java.util.List;
public interface LoginService {
    public List<Login> findAll();
    public Login save(Login login);
    public Login findById(Long id);
    public void delete(Login login);
}