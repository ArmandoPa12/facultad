package com.example.facultad.facultad.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.facultad.facultad.Dto.ActividadUsuarioDTO;
import com.example.facultad.facultad.Entity.Actividad;
import com.example.facultad.facultad.Entity.ActividadUsuario;
import com.example.facultad.facultad.Entity.Usuario;
import com.example.facultad.facultad.Service.ActividadService;
import com.example.facultad.facultad.Service.ActividadUsuarioService;
import com.example.facultad.facultad.Service.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping("api/actividad-usuario")
public class ActividadUsuarioController {
    @Autowired
    ActividadUsuarioService actividadUsuarioService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    ActividadService actividadService;

    @GetMapping
    public ResponseEntity<List<ActividadUsuario>> get() {
        List<ActividadUsuario> lista = actividadUsuarioService.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActividadUsuario> show(@PathVariable Long id) {
        ActividadUsuario ver = actividadUsuarioService.findById(id);
        return ResponseEntity.ok(ver);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ActividadUsuarioDTO actividadUsuarioDTO) {
        // boolean existeActivdad =
        // actividadUsuarioService.existsByActividadId(actividadUsuarioDTO.getActividad_id());
        // boolean existeUsuario =
        // actividadUsuarioService.existsByUsuarioId(actividadUsuarioDTO.getUsuario_id());

        // System.out.println(existeActivdad);
        // System.out.println(existeUsuario);
        // if ((existeActivdad) && (existeUsuario)) {
        // return ResponseEntity.ok(null);
        // }
        Usuario usuario = usuarioService.findById(actividadUsuarioDTO.getUsuario_id());
        Actividad actividad = actividadService.findById(actividadUsuarioDTO.getActividad_id());

        ActividadUsuario nuevo = new ActividadUsuario();
        nuevo.setUsuario(usuario);
        nuevo.setActividad(actividad);
        ActividadUsuario x = actividadUsuarioService.save(nuevo);
        return ResponseEntity.ok(x);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActividadUsuario> update(@PathVariable Long id,
            @RequestBody ActividadUsuarioDTO actividadUsuarioDTO) {
        // boolean existe =
        // actividadUsuarioService.existsByUsuarioIdAndActividadId(actividadUsuarioDTO.getUsuario_id(),
        // actividadUsuarioDTO.getActividad_id());
        // if (existe) {
        // return ResponseEntity.ok(null);
        // }
        ActividadUsuario editado = actividadUsuarioService.findById(id);
        Usuario usuario = usuarioService.findById(actividadUsuarioDTO.getUsuario_id());
        Actividad actividad = actividadService.findById(actividadUsuarioDTO.getActividad_id());
        editado.setUsuario(usuario);
        editado.setActividad(actividad);
        editado.setActividad(null);
        return ResponseEntity.ok(editado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        actividadUsuarioService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
