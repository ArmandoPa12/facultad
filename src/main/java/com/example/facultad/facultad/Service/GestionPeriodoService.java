package com.example.facultad.facultad.Service;

import java.util.List;

import com.example.facultad.facultad.Entity.GestionPeriodo;

public interface GestionPeriodoService {
    List<GestionPeriodo> findAll();

    GestionPeriodo findById(Long id);

    GestionPeriodo save(GestionPeriodo gestionPeriodo);

    void deleteById(Long id);
}
