package com.example.facultad.facultad.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "materia")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String sigla;
    @ManyToOne
    @JoinColumn(name = "carrera_id", nullable = false)
    Carrera carrera;

    public Materia() {
    }

    public Materia(Long id, String nombre, String sigla, Carrera carrera) {
        this.id = id;
        this.nombre = nombre;
        this.sigla = sigla;
        this.carrera = carrera;
    }

    // #region
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    // #endregion

    @Override
    public String toString() {
        return "Materia [id=" + id + ", nombre=" + nombre + ", sigla=" + sigla + ", carrera=" + carrera + "]";
    }

}
