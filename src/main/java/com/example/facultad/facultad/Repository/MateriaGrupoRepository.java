package com.example.facultad.facultad.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.facultad.facultad.Entity.MateriaGrupo;

@Repository
@EnableJpaRepositories
public interface MateriaGrupoRepository extends JpaRepository<MateriaGrupo, Long> {
    List<MateriaGrupo> findByMateriaId(Long materia_id);

}
