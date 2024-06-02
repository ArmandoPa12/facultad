package com.example.facultad.facultad.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.facultad.facultad.Dto.MateriaGrupoDTO;
import com.example.facultad.facultad.Entity.Grupo;
import com.example.facultad.facultad.Entity.Materia;
import com.example.facultad.facultad.Entity.MateriaGrupo;
import com.example.facultad.facultad.Service.GrupoService;
import com.example.facultad.facultad.Service.MateriaGrupoService;
import com.example.facultad.facultad.Service.MateriaService;

@CrossOrigin
@RestController
@RequestMapping("api/materia-grupo")
public class MateriaGrupoController {

    @Autowired
    MateriaGrupoService materiaGrupoService;
    @Autowired
    MateriaService materiaService;
    @Autowired
    GrupoService grupoService;

    @GetMapping
    public ResponseEntity<List<MateriaGrupo>> get() {
        List<MateriaGrupo> lista = materiaGrupoService.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<MateriaGrupo>> show(@PathVariable Long id) {
        List<MateriaGrupo> listaGrupos = materiaGrupoService.findByMateriaId(id);
        // MateriaGrupo ver = materiaGrupoService.findById(id);
        return ResponseEntity.ok(listaGrupos);
    }

    @PostMapping
    public ResponseEntity<MateriaGrupo> create(@RequestBody MateriaGrupoDTO materiaGrupoDTO) {
        Materia materia = materiaService.findById(materiaGrupoDTO.getMateria_id());
        Grupo grupo = grupoService.findById(materiaGrupoDTO.getGrupo_id());

        MateriaGrupo materiaGrupo = new MateriaGrupo();
        materiaGrupo.setMateria(materia);
        materiaGrupo.setGrupo(grupo);
        MateriaGrupo nuevo = materiaGrupoService.save(materiaGrupo);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MateriaGrupo> update(@PathVariable Long id, @RequestBody MateriaGrupoDTO materiaGrupoDTO) {
        Materia materia = materiaService.findById(materiaGrupoDTO.getMateria_id());
        Grupo grupo = grupoService.findById(materiaGrupoDTO.getGrupo_id());
        MateriaGrupo copia = materiaGrupoService.findById(id);
        copia.setMateria(materia);
        copia.setGrupo(grupo);
        MateriaGrupo editado = materiaGrupoService.save(copia);
        return ResponseEntity.ok(editado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        materiaGrupoService.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
