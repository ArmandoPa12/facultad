package com.example.facultad.facultad.Controller;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.facultad.facultad.Dto.GrupoAulaDTO;
import com.example.facultad.facultad.Entity.Aula;
import com.example.facultad.facultad.Entity.Dia;
import com.example.facultad.facultad.Entity.GrupoAula;
import com.example.facultad.facultad.Entity.MateriaGrupo;
import com.example.facultad.facultad.Service.AulaService;
import com.example.facultad.facultad.Service.DiaService;
import com.example.facultad.facultad.Service.GrupoAulaService;
import com.example.facultad.facultad.Service.MateriaGrupoService;

@CrossOrigin
@RestController
@RequestMapping("api/grupo-aula")
public class GrupoAulaController {
    @Autowired
    AulaService aulaService;
    @Autowired
    GrupoAulaService grupoAulaService;
    @Autowired
    MateriaGrupoService materiaGrupoService;
    @Autowired
    DiaService diaService;

    @GetMapping
    public ResponseEntity<List<GrupoAula>> get() {
        List<GrupoAula> lista = grupoAulaService.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoAula> show(@PathVariable Long id) {
        GrupoAula ver = grupoAulaService.findById(id);
        return ResponseEntity.ok(ver);
    }

    @PostMapping
    public ResponseEntity<GrupoAula> create(@RequestBody GrupoAulaDTO grupoAulaDTO) {
        Aula aula = aulaService.findById(grupoAulaDTO.getAula_id());
        MateriaGrupo materiaGrupo = materiaGrupoService.findById(grupoAulaDTO.getAula_id());
        Dia dia = diaService.findById(grupoAulaDTO.getDia_id());

        GrupoAula grupoAula = new GrupoAula();
        grupoAula.setHoraInicio(grupoAulaDTO.getHoraInicio());
        grupoAula.setHoraFin(grupoAulaDTO.getHoraFin());
        grupoAula.setAula(aula);
        grupoAula.setDia(dia);
        grupoAula.setMateriaGrupo(materiaGrupo);

        LocalTime horaInicio = LocalTime.parse(grupoAulaDTO.getHoraInicio().toString());
        LocalTime horaFin = LocalTime.parse(grupoAulaDTO.getHoraFin().toString());
        Duration duration = Duration.between(horaInicio, horaFin);
        BigDecimal duracionClase = BigDecimal.valueOf(duration.toMinutes()).divide(BigDecimal.valueOf(60), 2);
        grupoAula.setDuracionclase(duracionClase);

        if (grupoAulaService.verificarConflictoHorario(grupoAula)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        GrupoAula nuevo = grupoAulaService.save(grupoAula);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrupoAula> update(@PathVariable Long id, @RequestBody GrupoAulaDTO grupoAulaDTO) {
        Aula aula = aulaService.findById(grupoAulaDTO.getAula_id());
        MateriaGrupo materiaGrupo = materiaGrupoService.findById(grupoAulaDTO.getAula_id());
        Dia dia = diaService.findById(grupoAulaDTO.getDia_id());
        GrupoAula copia = grupoAulaService.findById(id);
        copia.setHoraInicio(grupoAulaDTO.getHoraInicio());
        copia.setHoraFin(grupoAulaDTO.getHoraFin());
        copia.setAula(aula);
        copia.setDia(dia);
        copia.setMateriaGrupo(materiaGrupo);
        GrupoAula editado = grupoAulaService.save(copia);
        return ResponseEntity.ok(editado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        grupoAulaService.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
