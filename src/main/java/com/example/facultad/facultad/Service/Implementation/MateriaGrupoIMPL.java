package com.example.facultad.facultad.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facultad.facultad.Entity.MateriaGrupo;
import com.example.facultad.facultad.Repository.MateriaGrupoRepository;
import com.example.facultad.facultad.Service.MateriaGrupoService;

@Service
public class MateriaGrupoIMPL implements MateriaGrupoService {

    @Autowired
    MateriaGrupoRepository materiaGrupoRepository;

    @Override
    public List<MateriaGrupo> findAll() {
        return materiaGrupoRepository.findAll();
    }

    @Override
    public MateriaGrupo findById(Long id) {
        return materiaGrupoRepository.findById(id).orElseThrow();
    }

    @Override
    public MateriaGrupo save(MateriaGrupo materiaGrupo) {
        return materiaGrupoRepository.save(materiaGrupo);
    }

    @Override
    public void deleteById(Long id) {
        materiaGrupoRepository.deleteById(id);
    }

    @Override
    public List<MateriaGrupo> findByMateriaId(Long materia_id) {
        return materiaGrupoRepository.findByMateriaId(materia_id);
    }
}
