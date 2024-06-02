package com.example.facultad.facultad.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facultad.facultad.Entity.Carrera;
import com.example.facultad.facultad.Repository.CarreraRespository;
import com.example.facultad.facultad.Service.CarreraService;

@Service
public class CarreraIMPL implements CarreraService {

    @Autowired
    CarreraRespository carreraRespository;

    @Override
    public List<Carrera> findAll() {
        return carreraRespository.findAll();
    }

    @Override
    public Carrera findById(Long id) {
        return carreraRespository.findById(id).orElseThrow();
    }

    @Override
    public Carrera save(Carrera carrera) {
        return carreraRespository.save(carrera);
    }

    @Override
    public void deleteById(Long id) {
        carreraRespository.deleteById(id);
    }

}
