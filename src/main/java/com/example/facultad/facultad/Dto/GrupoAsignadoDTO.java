package com.example.facultad.facultad.Dto;

import java.time.LocalTime;

public class GrupoAsignadoDTO {

    private Long id;
    private Long gestionPeriodo_id;
    private Long materiaGrupo_id;
    private Long usuario_id;
    private LocalTime horas_asignadas;

    public GrupoAsignadoDTO() {
    }

    public GrupoAsignadoDTO(Long id, Long gestionPeriodo_id, Long materiaGrupo_id, LocalTime horas_asignadas) {
        this.id = id;
        this.gestionPeriodo_id = gestionPeriodo_id;
        this.materiaGrupo_id = materiaGrupo_id;
        this.horas_asignadas = horas_asignadas;
    }

    public GrupoAsignadoDTO(Long id, Long gestionPeriodo_id, Long materiaGrupo_id, Long usuario_id,
            LocalTime horas_asignadas) {
        this.id = id;
        this.gestionPeriodo_id = gestionPeriodo_id;
        this.materiaGrupo_id = materiaGrupo_id;
        this.usuario_id = usuario_id;
        this.horas_asignadas = horas_asignadas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGestionPeriodo_id() {
        return gestionPeriodo_id;
    }

    public void setGestionPeriodo_id(Long gestionPeriodo_id) {
        this.gestionPeriodo_id = gestionPeriodo_id;
    }

    public Long getMateriaGrupo_id() {
        return materiaGrupo_id;
    }

    public void setMateriaGrupo_id(Long materiaGrupo_id) {
        this.materiaGrupo_id = materiaGrupo_id;
    }

    public LocalTime getHoras_asignadas() {
        return horas_asignadas;
    }

    public void setHoras_asignadas(LocalTime horas_asignadas) {
        this.horas_asignadas = horas_asignadas;
    }

    @Override
    public String toString() {
        return "GrupoAsignadoDTO [id=" + id + ", gestionPeriodo_id=" + gestionPeriodo_id + ", materiaGrupo_id="
                + materiaGrupo_id + ", horas_asignadas=" + horas_asignadas + "]";
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

}
