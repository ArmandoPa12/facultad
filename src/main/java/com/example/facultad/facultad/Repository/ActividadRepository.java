package com.example.facultad.facultad.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.facultad.facultad.Entity.Actividad;

@Repository
@EnableJpaRepositories
public interface ActividadRepository extends JpaRepository<Actividad, Long> {

}
