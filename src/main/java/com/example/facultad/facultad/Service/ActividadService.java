package com.example.facultad.facultad.Service;

import java.util.List;

import com.example.facultad.facultad.Entity.Actividad;

public interface ActividadService {
    List<Actividad> findAll();

    Actividad findById(Long id);

    Actividad save(Actividad aula);

    void deleteById(Long id);
}
