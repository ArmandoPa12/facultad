package com.example.facultad.facultad.Service;

import java.util.List;

import com.example.facultad.facultad.Entity.MateriaGrupo;

public interface MateriaGrupoService {
    List<MateriaGrupo> findAll();

    MateriaGrupo findById(Long id);

    MateriaGrupo save(MateriaGrupo materiaGrupo);

    void deleteById(Long id);

    List<MateriaGrupo> findByMateriaId(Long materia_id);

}
