package com.example.facultad.facultad.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "materia_grupo")
public class MateriaGrupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "materia_id", nullable = false)
    Materia materia;
    @ManyToOne
    @JoinColumn(name = "grupo_id", nullable = false)
    Grupo grupo;

    public MateriaGrupo() {
    }

    public MateriaGrupo(Long id, Materia materia, Grupo grupo) {
        this.id = id;
        this.materia = materia;
        this.grupo = grupo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "MateriaGrupo [id=" + id + ", materia=" + materia + ", grupo=" + grupo + "]";
    }

}
