package com.example.facultad.facultad.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facultad.facultad.Entity.ActividadUsuario;
import com.example.facultad.facultad.Repository.ActividadUsuarioRepository;
import com.example.facultad.facultad.Service.ActividadUsuarioService;

@Service
public class ActividadUsuarioIMPL implements ActividadUsuarioService {

    @Autowired
    ActividadUsuarioRepository actividadUsuarioRepository;

    @Override
    public List<ActividadUsuario> findAll() {
        return actividadUsuarioRepository.findAll();
    }

    @Override
    public ActividadUsuario findById(Long id) {
        return actividadUsuarioRepository.findById(id).orElseThrow();
    }

    @Override
    public ActividadUsuario save(ActividadUsuario actividadUsuario) {
        return actividadUsuarioRepository.save(actividadUsuario);
    }

    @Override
    public void deleteById(Long id) {
        actividadUsuarioRepository.deleteById(id);
    }

    @Override
    public boolean existsByUsuarioId(Long usuario_id) {
        return actividadUsuarioRepository.existsByUsuarioId(usuario_id);
    }

    @Override
    public boolean existsByActividadId(Long actividad_id) {
        return actividadUsuarioRepository.existsByActividadId(actividad_id);
    }

}
