package com.example.facultad.facultad.Dto;

public class MateriaDTO {
    private Long id;
    private Long carrera_id;
    private String nombre;
    private String sigla;

    public MateriaDTO() {
    }

    public MateriaDTO(Long id, Long carrera_id, String nombre, String sigla) {
        this.id = id;
        this.carrera_id = carrera_id;
        this.nombre = nombre;
        this.sigla = sigla;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarrera_id() {
        return carrera_id;
    }

    public void setCarrera_id(Long carrera_id) {
        this.carrera_id = carrera_id;
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

    @Override
    public String toString() {
        return "MateriaDTO [id=" + id + ", carrera_id=" + carrera_id + ", nombre=" + nombre + ", sigla=" + sigla + "]";
    }

}
