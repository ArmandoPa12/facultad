package com.example.facultad.facultad.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facultad.facultad.Entity.GrupoAula;
import com.example.facultad.facultad.Repository.GrupoAulaRepository;
import com.example.facultad.facultad.Service.GrupoAulaService;

@Service
public class GrupoAulaIMPL implements GrupoAulaService {
    @Autowired
    GrupoAulaRepository grupoAulaRepository;

    @Override
    public List<GrupoAula> findAll() {
        return grupoAulaRepository.findAll();
    }

    @Override
    public GrupoAula findById(Long id) {
        return grupoAulaRepository.findById(id).orElseThrow();
    }

    @Override
    public GrupoAula save(GrupoAula grupoAula) {
        return grupoAulaRepository.save(grupoAula);
    }

    @Override
    public void deleteById(Long id) {
        grupoAulaRepository.deleteById(id);
    }
}
