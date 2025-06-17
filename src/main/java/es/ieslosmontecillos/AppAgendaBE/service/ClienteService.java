package es.ieslosmontecillos.AppAgendaBE.service;

import es.ieslosmontecillos.AppAgendaBE.entity.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> findAll();
    Cliente save(Cliente cliente);
    Cliente findById(Long id);
    void delete(Cliente cliente);
}
