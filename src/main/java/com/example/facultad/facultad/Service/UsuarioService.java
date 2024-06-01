package com.example.facultad.facultad.Service;

import com.example.facultad.facultad.Dto.LoginDTO;
import com.example.facultad.facultad.Dto.UsuarioDTO;
import com.example.facultad.facultad.Response.LoginResponse;

public interface UsuarioService {

    String addUsuario(UsuarioDTO usuarioDTO);

    // LoginResponse loginUsuario(LoginDTO loginDTO);
    LoginResponse loginUsuario(LoginDTO loginDTO);

}
