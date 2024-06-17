package com.example.facultad.facultad.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.facultad.facultad.Dto.LoginDTO;
import com.example.facultad.facultad.Dto.UsuarioDTO;
import com.example.facultad.facultad.Entity.Usuario;
import com.example.facultad.facultad.Response.LoginResponse;
import com.example.facultad.facultad.Service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping("api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> get() {
        List<Usuario> lista = usuarioService.findAll();
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario x) {
        Usuario editad = usuarioService.findById(id);
        editad.setNombre(x.getNombre());
        editad.setApellidos(x.getApellidos());
        editad.setCi(x.getCi());
        editad.setTelefono(x.getTelefono());
        editad.setRol(x.getRol());
        editad.setSueldo(x.getSueldo());

        Usuario e = usuarioService.save(editad);

        return ResponseEntity.ok(e);
    }

    @PostMapping(path = "/save")
    public String saveUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        String id = usuarioService.addUsuario(usuarioDTO);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUsuario(@RequestBody LoginDTO loginDTO) {
        LoginResponse loginMessage = usuarioService.loginUsuario(loginDTO);
        return ResponseEntity.ok(loginMessage);
    }

}
