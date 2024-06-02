package com.example.facultad.facultad.Service;

import java.util.List;

import com.example.facultad.facultad.Entity.GrupoAula;

public interface GrupoAulaService {
    List<GrupoAula> findAll();

    GrupoAula findById(Long id);

    GrupoAula save(GrupoAula grupoAula);

    void deleteById(Long id);
}
