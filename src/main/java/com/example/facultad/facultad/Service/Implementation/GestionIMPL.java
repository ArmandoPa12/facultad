package com.example.facultad.facultad.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facultad.facultad.Entity.Gestion;
import com.example.facultad.facultad.Repository.GestionRepository;
import com.example.facultad.facultad.Service.GestionService;

@Service
public class GestionIMPL implements GestionService {

    @Autowired
    private GestionRepository gestionRepository;

    @Override
    public List<Gestion> findAll() {
        return gestionRepository.findAll();
    }

    @Override
    public Gestion findById(Long id) {
        return gestionRepository.findById(id).orElse(null);
    }

    @Override
    public Gestion save(Gestion gestion) {
        return gestionRepository.save(gestion);
    }

    @Override
    public void deleteById(Long id) {
        gestionRepository.deleteById(id);
    }

}
