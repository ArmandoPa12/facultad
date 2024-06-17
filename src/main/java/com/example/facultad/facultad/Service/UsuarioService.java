package com.example.facultad.facultad.Service;

import java.util.List;

import com.example.facultad.facultad.Dto.LoginDTO;
import com.example.facultad.facultad.Dto.UsuarioDTO;
import com.example.facultad.facultad.Entity.Usuario;
import com.example.facultad.facultad.Response.LoginResponse;

public interface UsuarioService {

    String addUsuario(UsuarioDTO usuarioDTO);

    // LoginResponse loginUsuario(LoginDTO loginDTO);
    LoginResponse loginUsuario(LoginDTO loginDTO);

    Usuario findById(Long id);

    Usuario save(Usuario usuario);

    void deleteById(Long id);

    List<Usuario> findAll();

}
