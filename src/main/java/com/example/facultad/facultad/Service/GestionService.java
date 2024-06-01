package com.example.facultad.facultad.Service;

import java.util.List;

import com.example.facultad.facultad.Entity.Gestion;

public interface GestionService {
    List<Gestion> findAll();

    Gestion findById(Long id);

    Gestion save(Gestion gestion);

    void deleteById(Long id);
}
