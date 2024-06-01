package com.example.facultad.facultad.Entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "periodo")
public class Periodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "periodo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GestionPeriodo> gestionPeriodos;

    private Periodo() {
    }

    public Periodo(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Periodo [id=" + id + ", nombre=" + nombre + ", gestionPeriodos=" + gestionPeriodos + "]";
    }

}
