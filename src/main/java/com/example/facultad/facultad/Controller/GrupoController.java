package com.example.facultad.facultad.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.facultad.facultad.Entity.Grupo;
import com.example.facultad.facultad.Service.GrupoService;

@CrossOrigin
@RestController
@RequestMapping("api/grupo")
public class GrupoController {

    @Autowired
    GrupoService grupoService;

    @GetMapping
    public ResponseEntity<List<Grupo>> get() {
        List<Grupo> lista = grupoService.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grupo> show(@PathVariable Long id) {
        Grupo ver = grupoService.findById(id);
        return ResponseEntity.ok(ver);
    }

    @PostMapping
    public ResponseEntity<Grupo> create(@RequestBody Grupo grupo) {
        Grupo nuevo = grupoService.save(grupo);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grupo> update(@PathVariable Long id, @RequestBody Grupo grupo) {
        Grupo copia = grupoService.findById(id);
        copia.setNombre(grupo.getNombre());
        copia.setSigla(grupo.getSigla());
        Grupo editado = grupoService.save(copia);
        return ResponseEntity.ok(editado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        grupoService.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
