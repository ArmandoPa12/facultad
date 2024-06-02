package com.example.facultad.facultad.Service;

import java.util.List;

import com.example.facultad.facultad.Entity.Grupo;

public interface GrupoService {
    List<Grupo> findAll();

    Grupo findById(Long id);

    Grupo save(Grupo grupo);

    void deleteById(Long id);

}
