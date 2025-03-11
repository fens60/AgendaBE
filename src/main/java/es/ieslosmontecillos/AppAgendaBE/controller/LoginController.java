package es.ieslosmontecillos.AppAgendaBE.controller;

import es.ieslosmontecillos.AppAgendaBE.entity.Login;
import es.ieslosmontecillos.AppAgendaBE.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/usuario")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @GetMapping(value="/LOGIN")
    public ResponseEntity<Object> get(){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Login> list = loginService.findAll();
            return new ResponseEntity<Object>(list,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value="/LOGIN/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        try {
            Login data = loginService.findById(id);
            return new ResponseEntity<Object>(data,HttpStatus.OK);
        }
        catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value="/LOGIN")
    public ResponseEntity<Object> create(@RequestBody Login provincia){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Login res = loginService.save(provincia);
            return new ResponseEntity<Object>(res,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/LOGIN/{id}")
    public ResponseEntity<Object> update(@RequestBody Login provincia,
                                         @PathVariable Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Login currentLogin = loginService.findById(id);
            currentLogin.setEmail(provincia.getEmail());
            currentLogin.setClave(provincia.getClave());
            currentLogin.setVigencia(provincia.getVigencia());
            Login res = loginService.save(currentLogin);
            return new ResponseEntity<Object>(res,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/LOGIN/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Login currentlogin = loginService.findById(id);
            loginService.delete(currentlogin);
            map.put("deleted", true);
            return new ResponseEntity<Object>(map,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
