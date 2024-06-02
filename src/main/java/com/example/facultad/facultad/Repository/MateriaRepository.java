package com.example.facultad.facultad.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.facultad.facultad.Entity.Materia;

@EnableJpaRepositories
@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {

}
