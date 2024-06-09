package com.example.facultad.facultad.Service;

import java.util.List;

import com.example.facultad.facultad.Entity.GrupoAsignado;

public interface GrupoAsignadoService {
    List<GrupoAsignado> findAll();

    GrupoAsignado findById(Long id);

    GrupoAsignado save(GrupoAsignado gestion);

    void deleteById(Long id);
}
