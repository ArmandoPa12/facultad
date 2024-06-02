package com.example.facultad.facultad.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "modulo")
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double latitud;
    private Double longitud;
    private String facultad;

    public Modulo() {
    }

    public Modulo(Long id, String nombre, Double latitud, Double longitud, String facultad) {
        this.id = id;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.facultad = facultad;
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

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    @Override
    public String toString() {
        return "Modulo [id=" + id + ", nombre=" + nombre + ", latitud=" + latitud + ", longitud=" + longitud
                + ", facultad=" + facultad + "]";
    }

}
