package com.example.facultad.facultad.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "aula")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String piso;
    @ManyToOne
    @JoinColumn(name = "modulo_id", nullable = false)
    Modulo modulo;

    public Aula() {
    }

    public Aula(Long id, String nombre, String piso, Modulo modulo) {
        this.id = id;
        this.nombre = nombre;
        this.piso = piso;
        this.modulo = modulo;
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

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    @Override
    public String toString() {
        return "Aula [id=" + id + ", nombre=" + nombre + ", piso=" + piso + ", modulo=" + modulo + "]";
    }

}
