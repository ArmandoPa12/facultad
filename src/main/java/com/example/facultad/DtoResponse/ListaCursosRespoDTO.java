package com.example.facultad.DtoResponse;

import java.time.LocalTime;

public class ListaCursosRespoDTO {
    private Long id;
    private LocalTime hora_inicio;
    private LocalTime hora_fin;
    // aula
    private Long aula_id;
    private String aula_nombre;
    private String aula_piso;
    // dia
    private Long dia_id;
    private String dia_nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalTime getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(LocalTime hora_fin) {
        this.hora_fin = hora_fin;
    }

    public Long getAula_id() {
        return aula_id;
    }

    public void setAula_id(Long aula_id) {
        this.aula_id = aula_id;
    }

    public String getAula_nombre() {
        return aula_nombre;
    }

    public void setAula_nombre(String aula_nombre) {
        this.aula_nombre = aula_nombre;
    }

    public String getAula_piso() {
        return aula_piso;
    }

    public void setAula_piso(String aula_piso) {
        this.aula_piso = aula_piso;
    }

    public Long getDia_id() {
        return dia_id;
    }

    public void setDia_id(Long dia_id) {
        this.dia_id = dia_id;
    }

    public String getDia_nombre() {
        return dia_nombre;
    }

    public void setDia_nombre(String dia_nombre) {
        this.dia_nombre = dia_nombre;
    }

    public ListaCursosRespoDTO() {
    }

    public ListaCursosRespoDTO(Long id, LocalTime hora_inicio, LocalTime hora_fin, Long aula_id, String aula_nombre,
            String aula_piso, Long dia_id, String dia_nombre) {
        this.id = id;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.aula_id = aula_id;
        this.aula_nombre = aula_nombre;
        this.aula_piso = aula_piso;
        this.dia_id = dia_id;
        this.dia_nombre = dia_nombre;
    }

}
