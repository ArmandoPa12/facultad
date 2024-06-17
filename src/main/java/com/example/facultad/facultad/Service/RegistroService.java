package com.example.facultad.facultad.Service;

import java.util.List;

import com.example.facultad.facultad.Entity.Registro;

public interface RegistroService {

    List<Registro> findAll();

    Registro findById(Long id);

    Registro save(Registro registro);

    void deleteById(Long id);

    List<Registro> findAllByUsuarioId(Long usuarioId);

}
