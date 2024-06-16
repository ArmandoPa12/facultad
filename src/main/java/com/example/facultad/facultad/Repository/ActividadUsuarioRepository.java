package com.example.facultad.facultad.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.facultad.facultad.Entity.ActividadUsuario;

@Repository
@EnableJpaRepositories
public interface ActividadUsuarioRepository extends JpaRepository<ActividadUsuario, Long> {
    boolean existsByUsuarioId(Long usuario_id);

    boolean existsByActividadId(Long actividad_id);
}
