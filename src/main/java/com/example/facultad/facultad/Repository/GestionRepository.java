package com.example.facultad.facultad.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.facultad.facultad.Entity.Gestion;

@EnableJpaRepositories
@Repository
public interface GestionRepository extends JpaRepository<Gestion, Long> {

}
