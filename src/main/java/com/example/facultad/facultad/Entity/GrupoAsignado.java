package com.example.facultad.facultad.Entity;

import java.math.BigDecimal;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "grupo_asignado")
public class GrupoAsignado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(precision = 19, scale = 2)
    private BigDecimal horas_asignadas;

    @ManyToOne
    @JoinColumn(name = "gestion_periodo_id", nullable = false)
    GestionPeriodo gestionPeriodo;
    @ManyToOne
    @JoinColumn(name = "materia_grupo_id", nullable = false)
    MateriaGrupo materiaGrupo;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    Usuario usuario;

    public GrupoAsignado() {
    }

    public GrupoAsignado(Long id, BigDecimal horas_asignadas, GestionPeriodo gestionPeriodo, MateriaGrupo materiaGrupo,
            Usuario usuario) {
        this.id = id;
        this.horas_asignadas = horas_asignadas;
        this.gestionPeriodo = gestionPeriodo;
        this.materiaGrupo = materiaGrupo;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getHoras_asignadas() {
        return horas_asignadas;
    }

    public void setHoras_asignadas(BigDecimal horas_asignadas) {
        this.horas_asignadas = horas_asignadas;
    }

    public GestionPeriodo getGestionPeriodo() {
        return gestionPeriodo;
    }

    public void setGestionPeriodo(GestionPeriodo gestionPeriodo) {
        this.gestionPeriodo = gestionPeriodo;
    }

    public MateriaGrupo getMateriaGrupo() {
        return materiaGrupo;
    }

    public void setMateriaGrupo(MateriaGrupo materiaGrupo) {
        this.materiaGrupo = materiaGrupo;
    }

    @Override
    public String toString() {
        return "GrupoAsignado [id=" + id + ", horas_asignadas=" + horas_asignadas + ", gestionPeriodo=" + gestionPeriodo
                + ", materiaGrupo=" + materiaGrupo + ", usuario=" + usuario + "]";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
