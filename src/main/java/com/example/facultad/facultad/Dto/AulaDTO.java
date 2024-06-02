package com.example.facultad.facultad.Dto;

public class AulaDTO {
    private Long id;
    private String nombre;
    private String piso;
    private Long modulo_id;

    public AulaDTO() {
    }

    public AulaDTO(Long id, String nombre, String piso, Long modulo_id) {
        this.id = id;
        this.nombre = nombre;
        this.piso = piso;
        this.modulo_id = modulo_id;
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

    public Long getModulo_id() {
        return modulo_id;
    }

    public void setModulo_id(Long modulo_id) {
        this.modulo_id = modulo_id;
    }

    @Override
    public String toString() {
        return "AulaDTO [id=" + id + ", nombre=" + nombre + ", piso=" + piso + ", modulo_id=" + modulo_id + "]";
    }

}
