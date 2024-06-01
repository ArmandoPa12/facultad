package com.example.facultad.facultad.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.facultad.facultad.Entity.Gestion;
import com.example.facultad.facultad.Service.GestionService;

@RestController
@CrossOrigin
@RequestMapping("api/gestion")
public class GestionController {

    @Autowired
    GestionService gestionService;

    @GetMapping
    public ResponseEntity<List<Gestion>> getGestion() {
        List<Gestion> gestiones = gestionService.findAll();
        return ResponseEntity.ok(gestiones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gestion> showGestion(@PathVariable Long id) {
        Gestion gestion = gestionService.findById(id);
        return ResponseEntity.ok(gestion);
    }

    @PostMapping
    public ResponseEntity<Gestion> createGestion(@RequestBody Gestion gestion) {
        Gestion nuevo = gestionService.save(gestion);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gestion> updateGestion(@PathVariable Long id, @RequestBody Gestion gestion) {
        Gestion copia = gestionService.findById(id);
        copia.setAnio(gestion.getAnio());
        copia.setFechaFin(gestion.getFechaFin());
        copia.setFechaIni(gestion.getFechaIni());

        Gestion nuevo = gestionService.save(copia);
        return ResponseEntity.ok(nuevo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGestion(@PathVariable Long id) {
        gestionService.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
