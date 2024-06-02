package com.example.facultad.facultad.Service;

import java.util.List;

import com.example.facultad.facultad.Entity.Aula;

public interface AulaService {
    List<Aula> findAll();

    Aula findById(Long id);

    Aula save(Aula aula);

    void deleteById(Long id);
}
