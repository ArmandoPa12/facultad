package com.example.facultad.facultad.Service;

import java.util.List;

import com.example.facultad.facultad.Entity.Dia;

public interface DiaService {
    List<Dia> findAll();

    Dia findById(Long id);

    Dia save(Dia dia);

    void deleteById(Long id);
}
