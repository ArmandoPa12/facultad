package com.example.facultad.facultad.Service;

import java.util.List;

import com.example.facultad.facultad.Entity.Periodo;

public interface PeriodoService {
    List<Periodo> findAll();

    Periodo findById(Long id);

    Periodo save(Periodo periodo);

    void deleteById(Long id);
}
