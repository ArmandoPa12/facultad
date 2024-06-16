package com.example.facultad.facultad.Service;

import java.util.List;

import com.example.facultad.facultad.Entity.ActividadUsuario;

public interface ActividadUsuarioService {

    List<ActividadUsuario> findAll();

    ActividadUsuario findById(Long id);

    ActividadUsuario save(ActividadUsuario actividadUsuario);

    void deleteById(Long id);

    boolean existsByUsuarioId(Long usuario_id);

    boolean existsByActividadId(Long actividad_id);

}
