package com.example.facultad.facultad.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.facultad.facultad.Entity.Modulo;
import com.example.facultad.facultad.Service.ModuloService;

@CrossOrigin
@RestController
@RequestMapping("api/modulo")
public class ModuloController {
    @Autowired
    ModuloService moduloService;

    @GetMapping
    public ResponseEntity<List<Modulo>> get() {
        List<Modulo> lista = moduloService.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modulo> show(@PathVariable Long id) {
        Modulo ver = moduloService.findById(id);
        return ResponseEntity.ok(ver);
    }

    @PostMapping
    public ResponseEntity<Modulo> create(@RequestBody Modulo modulo) {
        Modulo nuevo = moduloService.save(modulo);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modulo> update(@PathVariable Long id, @RequestBody Modulo modulo) {
        Modulo copia = moduloService.findById(id);
        copia.setNombre(modulo.getNombre());
        copia.setLatitud(modulo.getLatitud());
        copia.setLongitud(modulo.getLongitud());
        copia.setFacultad(modulo.getFacultad());
        Modulo editado = moduloService.save(copia);
        return ResponseEntity.ok(editado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        moduloService.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
