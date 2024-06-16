package com.example.facultad.facultad.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facultad.facultad.Entity.Actividad;
import com.example.facultad.facultad.Repository.ActividadRepository;
import com.example.facultad.facultad.Service.ActividadService;

@Service
public class ActividadIMPL implements ActividadService {

    @Autowired
    ActividadRepository actividadRepository;

    @Override
    public List<Actividad> findAll() {
        return actividadRepository.findAll();
    }

    @Override
    public Actividad findById(Long id) {
        return actividadRepository.findById(id).orElseThrow();
    }

    @Override
    public Actividad save(Actividad actividad) {
        return actividadRepository.save(actividad);
    }

    @Override
    public void deleteById(Long id) {
        actividadRepository.deleteById(id);
    }

}
