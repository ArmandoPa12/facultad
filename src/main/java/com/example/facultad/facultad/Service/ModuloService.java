package com.example.facultad.facultad.Service;

import java.util.List;

import com.example.facultad.facultad.Entity.Modulo;

public interface ModuloService {
    List<Modulo> findAll();

    Modulo findById(Long id);

    Modulo save(Modulo modulo);

    void deleteById(Long id);
}
