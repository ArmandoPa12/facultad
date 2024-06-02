package com.example.facultad.facultad.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.facultad.facultad.Dto.MateriaDTO;
import com.example.facultad.facultad.Entity.Carrera;
import com.example.facultad.facultad.Entity.Materia;
import com.example.facultad.facultad.Service.CarreraService;
import com.example.facultad.facultad.Service.MateriaService;

@CrossOrigin
@RestController
@RequestMapping("api/materia")
public class MateriaController {

    @Autowired
    MateriaService materiaService;
    @Autowired
    CarreraService carreraService;

    @GetMapping
    public ResponseEntity<List<Materia>> getGestion() {
        List<Materia> lista = materiaService.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materia> showGestion(@PathVariable Long id) {
        Materia ver = materiaService.findById(id);
        return ResponseEntity.ok(ver);
    }

    @PostMapping
    public ResponseEntity<Materia> createGestion(@RequestBody MateriaDTO materiaDTO) {
        Carrera carrera = carreraService.findById(materiaDTO.getCarrera_id());
        Materia materia = new Materia();
        materia.setNombre(materiaDTO.getNombre());
        materia.setSigla(materiaDTO.getSigla());
        materia.setCarrera(carrera);
        Materia nuevo = materiaService.save(materia);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Materia> updateGestion(@PathVariable Long id, @RequestBody MateriaDTO materiaDTO) {
        Carrera carrera = carreraService.findById(materiaDTO.getCarrera_id());
        Materia materia = materiaService.findById(id);
        materia.setNombre(materiaDTO.getNombre());
        materia.setSigla(materiaDTO.getSigla());
        materia.setCarrera(carrera);
        Materia editado = materiaService.save(materia);
        return ResponseEntity.ok(editado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGestion(@PathVariable Long id) {
        materiaService.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
