package com.example.facultad.facultad.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facultad.facultad.Entity.GrupoAsignado;
import com.example.facultad.facultad.Repository.GrupoAsignadoRepository;
import com.example.facultad.facultad.Service.GrupoAsignadoService;

@Service
public class GrupoAsignadoIMPL implements GrupoAsignadoService {

    @Autowired
    GrupoAsignadoRepository grupoAsignadoRepository;

    @Override
    public List<GrupoAsignado> findAll() {
        return grupoAsignadoRepository.findAll();
    }

    @Override
    public GrupoAsignado findById(Long id) {
        return grupoAsignadoRepository.findById(id).orElseThrow();
    }

    @Override
    public GrupoAsignado save(GrupoAsignado grupoAsignado) {
        return grupoAsignadoRepository.save(grupoAsignado);
    }

    @Override
    public void deleteById(Long id) {
        grupoAsignadoRepository.deleteById(id);
    }

}
