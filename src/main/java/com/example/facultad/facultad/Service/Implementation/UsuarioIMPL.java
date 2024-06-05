package com.example.facultad.facultad.Service.Implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.facultad.facultad.Dto.LoginDTO;
import com.example.facultad.facultad.Dto.UsuarioDTO;
import com.example.facultad.facultad.Entity.Usuario;
import com.example.facultad.facultad.Repository.UsuarioRepository;
import com.example.facultad.facultad.Response.LoginResponse;
import com.example.facultad.facultad.Service.JwtService;
import com.example.facultad.facultad.Service.UsuarioService;

@Service
public class UsuarioIMPL implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Override
    public String addUsuario(UsuarioDTO usr) {
        Usuario usuario = new Usuario(
                usr.getId(),
                usr.getCi(),
                usr.getNombre(),
                usr.getApellidos(),
                usr.getUsuario(),
                this.passwordEncoder.encode(usr.getPassword()),
                usr.getTelefono(),
                usr.isSexo(),
                usr.isRol());

        usuarioRepository.save(usuario);
        return usuario.getUsuario();

    }

    @Override
    public LoginResponse loginUsuario(LoginDTO loginDTO) {
        LoginResponse res = new LoginResponse();
        Usuario employee1 = usuarioRepository.findByUsuario(loginDTO.getUsuario());
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Usuario> employee = usuarioRepository.findOneByUsuarioAndPassword(loginDTO.getUsuario(),
                        encodedPassword);
                if (employee.isPresent()) {
                    String token = jwtService.generateToken(loginDTO.getUsuario());
                    res.setMessage("Credenciales correctas");
                    res.setStatus(true);
                    res.setUsername(employee1.getUsuario());
                    res.setToken(token);
                    res.setUserId(employee1.getId());
                    return res;
                } else {

                    return new LoginResponse("Login Failed", false);
                }
            } else {

                return new LoginResponse("Login Failed", false);

            }
        } else {
            // return res;
            return new LoginResponse("Login Failed", false);

        }
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

}
