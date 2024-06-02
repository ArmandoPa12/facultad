package com.example.facultad.facultad.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facultad.facultad.Entity.Dia;
import com.example.facultad.facultad.Repository.DiaRepository;
import com.example.facultad.facultad.Service.DiaService;

@Service
public class DiaIMPL implements DiaService {
    @Autowired
    DiaRepository diaRepository;

    @Override
    public List<Dia> findAll() {
        return diaRepository.findAll();
    }

    @Override
    public Dia findById(Long id) {
        return diaRepository.findById(id).orElseThrow();
    }

    @Override
    public Dia save(Dia dia) {
        return diaRepository.save(dia);
    }

    @Override
    public void deleteById(Long id) {
        diaRepository.deleteById(id);
    }
}
