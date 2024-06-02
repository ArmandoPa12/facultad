package com.example.facultad.facultad.Dto;

public class MateriaGrupoDTO {
    private Long id;
    private Long materia_id;
    private Long grupo_id;

    public MateriaGrupoDTO() {
    }

    public MateriaGrupoDTO(Long id, Long materia_id, Long grupo_id) {
        this.id = id;
        this.materia_id = materia_id;
        this.grupo_id = grupo_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMateria_id() {
        return materia_id;
    }

    public void setMateria_id(Long materia_id) {
        this.materia_id = materia_id;
    }

    public Long getGrupo_id() {
        return grupo_id;
    }

    public void setGrupo_id(Long grupo_id) {
        this.grupo_id = grupo_id;
    }

    @Override
    public String toString() {
        return "MateriaGrupoDTO [id=" + id + ", materia_id=" + materia_id + ", grupo_id=" + grupo_id + "]";
    }

}
