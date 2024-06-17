package com.example.facultad.facultad.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facultad.facultad.Entity.Registro;
import com.example.facultad.facultad.Repository.RegistroRepository;
import com.example.facultad.facultad.Service.RegistroService;

@Service
public class RegistroIMPL implements RegistroService {

    @Autowired
    RegistroRepository registroRepository;

    @Override
    public List<Registro> findAll() {
        return registroRepository.findAll();
    }

    @Override
    public Registro findById(Long id) {
        return registroRepository.findById(id).orElseThrow();
    }

    @Override
    public Registro save(Registro registro) {
        return registroRepository.save(registro);
    }

    @Override
    public void deleteById(Long id) {
        registroRepository.deleteById(id);
    }

    @Override
    public List<Registro> findAllByUsuarioId(Long usuarioId) {
        return registroRepository.findAllByUsuarioId(usuarioId);
    }
}