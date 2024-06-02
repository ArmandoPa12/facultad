package com.example.facultad.facultad.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facultad.facultad.Entity.Materia;
import com.example.facultad.facultad.Repository.MateriaRepository;
import com.example.facultad.facultad.Service.MateriaService;

@Service
public class MateriaIMPL implements MateriaService {

    @Autowired
    MateriaRepository materiaRepository;

    @Override
    public List<Materia> findAll() {
        return materiaRepository.findAll();
    }

    @Override
    public Materia findById(Long id) {
        return materiaRepository.findById(id).orElseThrow();
    }

    @Override
    public Materia save(Materia materia) {
        return materiaRepository.save(materia);
    }

    @Override
    public void deleteById(Long id) {
        materiaRepository.deleteById(id);
    }

}
