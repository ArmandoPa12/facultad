package com.example.facultad.facultad.Controller;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.facultad.facultad.Entity.Actividad;

import com.example.facultad.facultad.Service.ActividadService;

@CrossOrigin
@RestController
@RequestMapping("api/actividad")
public class ActividadController {

    @Autowired
    ActividadService actividadService;

    @GetMapping
    public ResponseEntity<List<Actividad>> get() {
        List<Actividad> lista = actividadService.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actividad> show(@PathVariable Long id) {
        Actividad ver = actividadService.findById(id);
        return ResponseEntity.ok(ver);
    }

    @PostMapping
    public ResponseEntity<Actividad> create(@RequestBody Actividad actividad) {
        LocalTime horaInicio = LocalTime.parse(actividad.getHora_ini().toString());
        LocalTime horaFin = LocalTime.parse(actividad.getHora_fin().toString());
        Duration duracion = Duration.between(horaInicio, horaFin);
        BigDecimal duracionActividad = BigDecimal.valueOf(duracion.toMinutes()).divide(BigDecimal.valueOf(60), 2);

        actividad.setDuracion(duracionActividad);

        Actividad nuevo = actividadService.save(actividad);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actividad> update(@PathVariable Long id, @RequestBody Actividad actividad) {
        LocalTime horaInicio = LocalTime.parse(actividad.getHora_ini().toString());
        LocalTime horaFin = LocalTime.parse(actividad.getHora_fin().toString());
        Duration duracion = Duration.between(horaInicio, horaFin);
        BigDecimal duracionActividad = BigDecimal.valueOf(duracion.toMinutes()).divide(BigDecimal.valueOf(60), 2);

        actividad.setDuracion(duracionActividad);

        Actividad editado = actividadService.findById(id);
        editado.setNombre(actividad.getNombre());
        editado.setDireccion(actividad.getDireccion());
        editado.setDuracion(actividad.getDuracion());
        editado.setFecha(actividad.getFecha());
        editado.setHora_ini(actividad.getHora_ini());
        editado.setHora_fin(actividad.getHora_fin());
        Actividad guardar = actividadService.save(editado);
        return ResponseEntity.ok(guardar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        actividadService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
