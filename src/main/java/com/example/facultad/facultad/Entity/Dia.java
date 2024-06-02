package com.example.facultad.facultad.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dia")
public class Dia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    public Dia() {
    }

    public Dia(Long id, String nombre) {
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
        return "Dia [id=" + id + ", nombre=" + nombre + "]";
    }

}
