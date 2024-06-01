package com.example.facultad.facultad.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.facultad.facultad.Dto.GestionPeriodoDTO;
import com.example.facultad.facultad.Entity.Gestion;
import com.example.facultad.facultad.Entity.GestionPeriodo;
import com.example.facultad.facultad.Entity.Periodo;
import com.example.facultad.facultad.Service.GestionPeriodoService;
import com.example.facultad.facultad.Service.GestionService;
import com.example.facultad.facultad.Service.PeriodoService;

@CrossOrigin
@RestController
@RequestMapping("api/gestion-periodo")
public class GestionPeriodoController {
    @Autowired
    GestionPeriodoService gestionPeriodoService;
    @Autowired
    GestionService gestionService;
    @Autowired
    PeriodoService periodoService;

    @GetMapping
    public ResponseEntity<List<GestionPeriodo>> getGestionPeriodo() {
        List<GestionPeriodo> periodos = gestionPeriodoService.findAll();
        return ResponseEntity.ok(periodos);
    }

    @PostMapping
    public ResponseEntity<GestionPeriodo> createGestionPeriodo(@RequestBody GestionPeriodoDTO gestionPeriodoDTO) {
        System.out.println(gestionPeriodoDTO.toString());
        Gestion gestion = gestionService.findById(gestionPeriodoDTO.getGestion_id());
        Periodo periodo = periodoService.findById(gestionPeriodoDTO.getPeriodo_id());

        GestionPeriodo nuevo = new GestionPeriodo();
        nuevo.setEvaluacion1(gestionPeriodoDTO.getEvaluacion1());
        nuevo.setEvaluacion2(gestionPeriodoDTO.getEvaluacion2());
        nuevo.setEvaluacion3(gestionPeriodoDTO.getEvaluacion3());
        nuevo.setFin_clase(gestionPeriodoDTO.getFin_clase());
        nuevo.setGestion(gestion);
        nuevo.setPeriodo(periodo);
        nuevo.setInicio_clase(gestionPeriodoDTO.getInicio_clase());

        GestionPeriodo newPeriodo = gestionPeriodoService.save(nuevo);
        return ResponseEntity.ok(newPeriodo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GestionPeriodo> showGestionPeriodo(@PathVariable Long id) {
        GestionPeriodo periodo = gestionPeriodoService.findById(id);
        return ResponseEntity.ok(periodo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GestionPeriodo> updateGestionPeriodo(@PathVariable Long id,
            @RequestBody GestionPeriodoDTO gestionPeriodoDTO) {
        Gestion gestion = gestionService.findById(gestionPeriodoDTO.getGestion_id());
        Periodo periodo = periodoService.findById(gestionPeriodoDTO.getPeriodo_id());
        GestionPeriodo nuevo = gestionPeriodoService.findById(id);

        nuevo.setEvaluacion1(gestionPeriodoDTO.getEvaluacion1());
        nuevo.setEvaluacion2(gestionPeriodoDTO.getEvaluacion2());
        nuevo.setEvaluacion3(gestionPeriodoDTO.getEvaluacion3());
        nuevo.setFin_clase(gestionPeriodoDTO.getFin_clase());
        nuevo.setGestion(gestion);
        nuevo.setPeriodo(periodo);
        nuevo.setInicio_clase(gestionPeriodoDTO.getInicio_clase());

        GestionPeriodo newPeriodo = gestionPeriodoService.save(nuevo);

        return ResponseEntity.ok(newPeriodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGestionPeriodo(@PathVariable Long id) {
        gestionPeriodoService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
