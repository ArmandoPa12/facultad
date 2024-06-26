package com.example.facultad.facultad.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.facultad.facultad.Entity.Registro;

@Repository
@EnableJpaRepositories
public interface RegistroRepository extends JpaRepository<Registro, Long> {

    List<Registro> findAllById(Long id);

    List<Registro> findAllByUsuarioId(Long usuarioId);

}
