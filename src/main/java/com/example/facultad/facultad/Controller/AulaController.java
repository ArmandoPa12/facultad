package com.example.facultad.facultad.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.facultad.facultad.Dto.AulaDTO;
import com.example.facultad.facultad.Entity.Aula;
import com.example.facultad.facultad.Entity.Modulo;
import com.example.facultad.facultad.Service.AulaService;
import com.example.facultad.facultad.Service.ModuloService;

@CrossOrigin
@RestController
@RequestMapping("api/aula")
public class AulaController {
    @Autowired
    AulaService aulaService;
    @Autowired
    ModuloService moduloService;

    @GetMapping
    public ResponseEntity<List<Aula>> get() {
        List<Aula> lista = aulaService.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aula> show(@PathVariable Long id) {
        Aula ver = aulaService.findById(id);
        return ResponseEntity.ok(ver);
    }

    @PostMapping
    public ResponseEntity<Aula> create(@RequestBody AulaDTO aulaDTO) {
        Modulo modulo = moduloService.findById(aulaDTO.getModulo_id());
        Aula aula = new Aula();
        aula.setNombre(aulaDTO.getNombre());
        aula.setPiso(aulaDTO.getPiso());
        aula.setModulo(modulo);
        Aula nuevo = aulaService.save(aula);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aula> update(@PathVariable Long id, @RequestBody AulaDTO aulaDTO) {
        Aula copia = aulaService.findById(id);
        Modulo modulo = moduloService.findById(aulaDTO.getModulo_id());

        copia.setNombre(aulaDTO.getNombre());
        copia.setPiso(aulaDTO.getPiso());
        copia.setModulo(modulo);

        Aula editado = aulaService.save(copia);
        return ResponseEntity.ok(editado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        aulaService.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
