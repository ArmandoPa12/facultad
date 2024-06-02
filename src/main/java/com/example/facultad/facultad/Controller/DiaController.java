package com.example.facultad.facultad.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.facultad.facultad.Entity.Dia;
import com.example.facultad.facultad.Service.DiaService;

@CrossOrigin
@RestController
@RequestMapping("api/dia")
public class DiaController {
    @Autowired
    DiaService diaService;

    @GetMapping
    public ResponseEntity<List<Dia>> get() {
        List<Dia> lista = diaService.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dia> show(@PathVariable Long id) {
        Dia ver = diaService.findById(id);
        return ResponseEntity.ok(ver);
    }

    @PostMapping
    public ResponseEntity<Dia> create(@RequestBody Dia dia) {
        Dia nuevo = diaService.save(dia);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dia> update(@PathVariable Long id, @RequestBody Dia dia) {
        Dia copia = diaService.findById(id);
        copia.setNombre(dia.getNombre());
        Dia editado = diaService.save(copia);
        return ResponseEntity.ok(editado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        diaService.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
