package com.example.facultad.facultad.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.facultad.facultad.Entity.GrupoAula;

@Repository
@EnableJpaRepositories
public interface GrupoAulaRepository extends JpaRepository<GrupoAula, Long> {

    List<GrupoAula> findByAulaIdAndDiaId(Long aula_id, Long dia_id);

    List<GrupoAula> findByMateriaGrupoId(Long aula_id);

}
