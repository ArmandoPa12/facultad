package com.example.facultad.facultad.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facultad.facultad.Entity.Modulo;
import com.example.facultad.facultad.Repository.ModuloRepository;
import com.example.facultad.facultad.Service.ModuloService;

@Service
public class ModuloIMPL implements ModuloService {
    @Autowired
    ModuloRepository moduloRepository;

    @Override
    public List<Modulo> findAll() {
        return moduloRepository.findAll();
    }

    @Override
    public Modulo findById(Long id) {
        return moduloRepository.findById(id).orElseThrow();
    }

    @Override
    public Modulo save(Modulo modulo) {
        return moduloRepository.save(modulo);
    }

    @Override
    public void deleteById(Long id) {
        moduloRepository.deleteById(id);
    }
}
