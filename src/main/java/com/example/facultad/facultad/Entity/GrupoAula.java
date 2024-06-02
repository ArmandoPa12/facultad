package com.example.facultad.facultad.Entity;

import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "grupo_aula")
public class GrupoAula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "materia_grupo_id", nullable = false)
    private MateriaGrupo materiaGrupo;

    @ManyToOne
    @JoinColumn(name = "aula_id", nullable = false)
    private Aula aula;

    @ManyToOne
    @JoinColumn(name = "dia_id", nullable = false)
    private Dia dia;

    private LocalTime horaInicio;
    private LocalTime horaFin;

    public GrupoAula() {
    }

    public GrupoAula(Long id, MateriaGrupo materiaGrupo, Aula aula, Dia dia, LocalTime horaInicio, LocalTime horaFin) {
        this.id = id;
        this.materiaGrupo = materiaGrupo;
        this.aula = aula;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MateriaGrupo getMateriaGrupo() {
        return materiaGrupo;
    }

    public void setMateriaGrupo(MateriaGrupo materiaGrupo) {
        this.materiaGrupo = materiaGrupo;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
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
        return "GrupoAula{" +
                "id=" + id +
                ", materiaGrupo=" + materiaGrupo +
                ", aula=" + aula +
                ", dia=" + dia +
                ", horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                '}';
    }

}
