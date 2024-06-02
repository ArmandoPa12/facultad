package com.example.facultad.facultad.Service;

import java.util.List;

import com.example.facultad.facultad.Entity.Carrera;

public interface CarreraService {
    List<Carrera> findAll();

    Carrera findById(Long id);

    Carrera save(Carrera carrera);

    void deleteById(Long id);

}
