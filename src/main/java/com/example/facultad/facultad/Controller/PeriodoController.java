package com.example.facultad.facultad.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.facultad.facultad.Entity.Periodo;
import com.example.facultad.facultad.Service.PeriodoService;

@RestController
@CrossOrigin
@RequestMapping("api/periodo")
public class PeriodoController {
    @Autowired
    private PeriodoService periodoService;

    @GetMapping
    public ResponseEntity<List<Periodo>> getPerido() {
        List<Periodo> periodos = periodoService.findAll();
        return ResponseEntity.ok(periodos);
    }

    @PostMapping
    public ResponseEntity<Periodo> createPeriodo(@RequestBody Periodo periodo) {
        Periodo newPeriodo = periodoService.save(periodo);
        return ResponseEntity.ok(newPeriodo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Periodo> showPeriodo(@PathVariable Long id) {
        Periodo periodo = periodoService.findById(id);
        return ResponseEntity.ok(periodo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Periodo> updatePeriodo(@PathVariable Long id, @RequestBody Periodo periodo) {
        Periodo updaPeriodo = periodoService.findById(id);

        updaPeriodo.setNombre(periodo.getNombre());
        Periodo updated = periodoService.save(updaPeriodo);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping
    public ResponseEntity<?> deletePeriodo(@PathVariable Long id) {
        periodoService.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
