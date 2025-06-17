package es.ieslosmontecillos.AppAgendaBE.controller;

import es.ieslosmontecillos.AppAgendaBE.entity.Usuario;
import es.ieslosmontecillos.AppAgendaBE.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/USUARIO")
    public ResponseEntity<Object> getAll() {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Usuario> list = usuarioService.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/USUARIO/{usuario}")
    public ResponseEntity<Object> getByUsuario(@PathVariable String usuario) {
        Map<String, Object> map = new HashMap<>();
        try {
            Usuario data = usuarioService.findByUsuario(usuario);
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/USUARIO")
    public ResponseEntity<Object> create(@RequestBody Usuario usuario) {
        Map<String, Object> map = new HashMap<>();
        try {
            Usuario res = usuarioService.save(usuario);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/USUARIO/{usuario}")
    public ResponseEntity<Object> update(@RequestBody Usuario usuario, @PathVariable String usuarioParam) {
        Map<String, Object> map = new HashMap<>();
        try {
            Usuario currentUsuario = usuarioService.findByUsuario(usuarioParam);
            currentUsuario.setUsuario(usuario.getUsuario());
            currentUsuario.setContrasena(usuario.getContrasena());
            currentUsuario.setTipo(usuario.getTipo());

            Usuario res = usuarioService.save(currentUsuario);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/USUARIO/{usuario}")
    public ResponseEntity<Object> delete(@PathVariable String usuario) {
        Map<String, Object> map = new HashMap<>();
        try {
            Usuario currentUsuario = usuarioService.findByUsuario(usuario);
            usuarioService.delete(currentUsuario);
            map.put("deleted", true);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
