package com.example.facultad.facultad.Service.Implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.facultad.facultad.Entity.Grupo;
import com.example.facultad.facultad.Repository.GrupoRepository;
import com.example.facultad.facultad.Service.GrupoService;

@Service
public class GrupoIMPL implements GrupoService {

    @Autowired
    GrupoRepository grupoRepository;

    @Override
    public List<Grupo> findAll() {
        return grupoRepository.findAll();
    }

    @Override
    public Grupo findById(Long id) {
        return grupoRepository.findById(id).orElseThrow();
    }

    @Override
    public Grupo save(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    @Override
    public void deleteById(Long id) {
        grupoRepository.deleteById(id);
    }

}
