package com.example.facultad.facultad.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.facultad.facultad.Dto.LoginDTO;
import com.example.facultad.facultad.Dto.UsuarioDTO;
import com.example.facultad.facultad.Response.LoginResponse;
import com.example.facultad.facultad.Service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping("api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(path = "/save")
    public String saveUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        String id = usuarioService.addUsuario(usuarioDTO);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUsuario(@RequestBody LoginDTO loginDTO) {
        // LoginResponse loginMessage = UsuarioService.loginUsuario(loginDTO);
        LoginResponse loginMessage = usuarioService.loginUsuario(loginDTO);
        return ResponseEntity.ok(loginMessage);
    }

}
