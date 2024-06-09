package com.example.facultad.facultad.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.facultad.facultad.Entity.Grupo;

@CrossOrigin
@RestController
@RequestMapping("api/info")
public class InfoController {

    // @GetMapping
    // public ResponseEntity<List<Grupo>> get() {
    // List<Grupo> lista = grupoService.findAll();
    // return ResponseEntity.ok(lista);
    // }

}
