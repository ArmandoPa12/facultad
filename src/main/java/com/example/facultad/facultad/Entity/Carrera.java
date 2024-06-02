package com.example.facultad.facultad.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "carrera")
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String sigla;
    private String sistema_academico;

    public Carrera() {
    }

    public Carrera(Long id, String nombre, String sigla, String sistema_academico) {
        this.id = id;
        this.nombre = nombre;
        this.sigla = sigla;
        this.sistema_academico = sistema_academico;
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
    // #endregion

    @Override
    public String toString() {
        return "Carrera [id=" + id + ", nombre=" + nombre + ", sigla=" + sigla + ", usuario=";
    }

    public String getSistema_academico() {
        return sistema_academico;
    }

    public void setSistema_academico(String sistema_academico) {
        this.sistema_academico = sistema_academico;
    }

}
