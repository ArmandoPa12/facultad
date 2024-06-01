package com.example.facultad.facultad.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facultad.facultad.Entity.Periodo;
import com.example.facultad.facultad.Repository.PeriodoRepository;
import com.example.facultad.facultad.Service.PeriodoService;

@Service
public class PeriodoIMPL implements PeriodoService {

    @Autowired
    private PeriodoRepository periodoRepository;

    @Override
    public List<Periodo> findAll() {
        return periodoRepository.findAll();
    }

    @Override
    public Periodo findById(Long id) {
        return periodoRepository.findById(id).orElse(null);
    }

    @Override
    public Periodo save(Periodo periodo) {
        return periodoRepository.save(periodo);
    }

    @Override
    public void deleteById(Long id) {
        periodoRepository.deleteById(id);
    }

}
