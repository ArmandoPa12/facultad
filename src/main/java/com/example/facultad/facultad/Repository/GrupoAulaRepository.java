package com.example.facultad.facultad.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.facultad.facultad.Entity.GrupoAula;

@Repository
@EnableJpaRepositories
public interface GrupoAulaRepository extends JpaRepository<GrupoAula, Long> {

}
