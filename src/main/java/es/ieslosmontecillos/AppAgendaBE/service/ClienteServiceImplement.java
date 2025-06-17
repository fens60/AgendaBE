package es.ieslosmontecillos.AppAgendaBE.service;


import es.ieslosmontecillos.AppAgendaBE.Dao.ClienteDao;
import es.ieslosmontecillos.AppAgendaBE.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImplement implements ClienteService{
    @Autowired
    private ClienteDao clienteDao;

    @Override
    public List<Cliente> findAll() {
        return clienteDao.findAll();
    }
    @Override
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }
    @Override
    public Cliente findById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }
    @Override
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }
}
