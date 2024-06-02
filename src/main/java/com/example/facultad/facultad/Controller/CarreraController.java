package com.example.facultad.facultad.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.facultad.facultad.Entity.Carrera;
import com.example.facultad.facultad.Service.CarreraService;

@CrossOrigin
@RestController
@RequestMapping("api/carrera")
public class CarreraController {

    @Autowired
    CarreraService carreraService;

    @GetMapping
    public ResponseEntity<List<Carrera>> getGestion() {
        List<Carrera> listas = carreraService.findAll();
        return ResponseEntity.ok(listas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrera> showGestion(@PathVariable Long id) {
        Carrera unico = carreraService.findById(id);
        return ResponseEntity.ok(unico);
    }

    @PostMapping
    public ResponseEntity<Carrera> createGestion(@RequestBody Carrera carrera) {
        Carrera nuevo = carreraService.save(carrera);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrera> updateGestion(@PathVariable Long id, @RequestBody Carrera carrera) {
        Carrera copia = carreraService.findById(id);
        copia.setNombre(carrera.getNombre());
        copia.setSigla(carrera.getSigla());
        copia.setSistema_academico(carrera.getSistema_academico());
        Carrera editado = carreraService.save(copia);
        return ResponseEntity.ok(editado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGestion(@PathVariable Long id) {
        carreraService.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
