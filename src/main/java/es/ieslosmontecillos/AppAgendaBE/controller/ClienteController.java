package es.ieslosmontecillos.AppAgendaBE.controller;

import es.ieslosmontecillos.AppAgendaBE.entity.Cliente;
import es.ieslosmontecillos.AppAgendaBE.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/CLIENTE")
    public ResponseEntity<Object> get() {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Cliente> list = clienteService.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/CLIENTE/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        try {
            Cliente data = clienteService.findById(id);
            return new ResponseEntity<Object>(data, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/CLIENTE")
    public ResponseEntity<Object> create(@RequestBody Cliente cliente) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Cliente res = clienteService.save(cliente);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/CLIENTE/{id}")
    public ResponseEntity<Object> update(@RequestBody Cliente cliente, @PathVariable Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Cliente currentCliente = clienteService.findById(id);

            currentCliente.setNombre(cliente.getNombre());
            currentCliente.setApellidos(cliente.getApellidos());
            currentCliente.setTelefono(cliente.getTelefono());
            currentCliente.setEmail(cliente.getEmail());
            currentCliente.setProvincia(cliente.getProvincia());
            currentCliente.setFecha(cliente.getFecha());
            currentCliente.setNumHijos(cliente.getNumHijos());
            currentCliente.setEstadoCivil(cliente.getEstadoCivil());
            currentCliente.setSalario(cliente.getSalario());
            currentCliente.setJubilado(cliente.getJubilado());
            currentCliente.setFoto(cliente.getFoto());

            Cliente res = clienteService.save(currentCliente);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/CLIENTE/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Cliente currentCliente = clienteService.findById(id);
            clienteService.delete(currentCliente);
            map.put("deleted", true);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
