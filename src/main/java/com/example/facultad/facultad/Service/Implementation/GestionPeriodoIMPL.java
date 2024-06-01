package com.example.facultad.facultad.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facultad.facultad.Entity.GestionPeriodo;
import com.example.facultad.facultad.Repository.GestionPeriodoRepository;
import com.example.facultad.facultad.Service.GestionPeriodoService;

@Service
public class GestionPeriodoIMPL implements GestionPeriodoService {

    @Autowired
    private GestionPeriodoRepository gestionPeriodoRepository;

    @Override
    public List<GestionPeriodo> findAll() {
        return gestionPeriodoRepository.findAll();
    }

    @Override
    public GestionPeriodo findById(Long id) {
        return gestionPeriodoRepository.findById(id).orElse(null);
    }

    @Override
    public GestionPeriodo save(GestionPeriodo gestionPeriodo) {
        return gestionPeriodoRepository.save(gestionPeriodo);
    }

    @Override
    public void deleteById(Long id) {
        gestionPeriodoRepository.deleteById(id);
    }

}
