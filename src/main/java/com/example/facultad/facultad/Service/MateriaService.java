package com.example.facultad.facultad.Service;

import java.util.List;

import com.example.facultad.facultad.Entity.Materia;

public interface MateriaService {
    List<Materia> findAll();

    Materia findById(Long id);

    Materia save(Materia materia);

    void deleteById(Long id);

}
