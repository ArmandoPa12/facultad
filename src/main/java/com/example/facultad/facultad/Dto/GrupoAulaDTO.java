package com.example.facultad.facultad.Dto;

import java.time.LocalTime;

public class GrupoAulaDTO {
    private Long materia_grupo_id;
    private Long aula_id;
    private Long dia_id;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public GrupoAulaDTO() {
    }

    public GrupoAulaDTO(Long materia_grupo_id, Long aula_id, Long dia_id, LocalTime horaInicio, LocalTime horaFin) {
        this.materia_grupo_id = materia_grupo_id;
        this.aula_id = aula_id;
        this.dia_id = dia_id;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Long getMateria_grupo_id() {
        return materia_grupo_id;
    }

    public void setMateria_grupo_id(Long materia_grupo_id) {
        this.materia_grupo_id = materia_grupo_id;
    }

    public Long getAula_id() {
        return aula_id;
    }

    public void setAula_id(Long aula_id) {
        this.aula_id = aula_id;
    }

    public Long getDia_id() {
        return dia_id;
    }

    public void setDia_id(Long dia_id) {
        this.dia_id = dia_id;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public String toString() {
        return "GrupoAulaDTO [materia_grupo_id=" + materia_grupo_id + ", aula_id=" + aula_id + ", dia_id=" + dia_id
                + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + "]";
    }

}
