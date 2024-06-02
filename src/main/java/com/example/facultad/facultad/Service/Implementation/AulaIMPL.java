package com.example.facultad.facultad.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facultad.facultad.Entity.Aula;
import com.example.facultad.facultad.Repository.AulaRepository;
import com.example.facultad.facultad.Service.AulaService;

@Service
public class AulaIMPL implements AulaService {
    @Autowired
    AulaRepository aulaRepository;

    @Override
    public List<Aula> findAll() {
        return aulaRepository.findAll();
    }

    @Override
    public Aula findById(Long id) {
        return aulaRepository.findById(id).orElseThrow();
    }

    @Override
    public Aula save(Aula aula) {
        return aulaRepository.save(aula);
    }

    @Override
    public void deleteById(Long id) {
        aulaRepository.deleteById(id);
    }

}
