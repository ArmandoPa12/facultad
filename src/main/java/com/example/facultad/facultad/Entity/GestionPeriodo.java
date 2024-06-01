package com.example.facultad.facultad.Entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "gestion_periodo")
public class GestionPeriodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "gestion_id", nullable = false)
    Gestion gestion;

    @ManyToOne
    @JoinColumn(name = "periodo_id", nullable = false)
    Periodo periodo;

    @Temporal(TemporalType.DATE)
    private Date inicio_clase;

    @Temporal(TemporalType.DATE)
    private Date fin_clase;

    @Temporal(TemporalType.DATE)
    private Date evaluacion1;

    @Temporal(TemporalType.DATE)
    private Date evaluacion2;

    @Temporal(TemporalType.DATE)
    private Date evaluacion3;

    public GestionPeriodo() {
    }

    public GestionPeriodo(Long id, Gestion gestion, Periodo periodo, Date inicio_clase, Date fin_clase,
            Date evaluacion1, Date evaluacion2, Date evaluacion3) {
        this.id = id;
        this.gestion = gestion;
        this.periodo = periodo;
        this.inicio_clase = inicio_clase;
        this.fin_clase = fin_clase;
        this.evaluacion1 = evaluacion1;
        this.evaluacion2 = evaluacion2;
        this.evaluacion3 = evaluacion3;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Gestion getGestion() {
        return gestion;
    }

    public void setGestion(Gestion gestion) {
        this.gestion = gestion;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Date getInicio_clase() {
        return inicio_clase;
    }

    public void setInicio_clase(Date inicio_clase) {
        this.inicio_clase = inicio_clase;
    }

    public Date getFin_clase() {
        return fin_clase;
    }

    public void setFin_clase(Date fin_clase) {
        this.fin_clase = fin_clase;
    }

    public Date getEvaluacion1() {
        return evaluacion1;
    }

    public void setEvaluacion1(Date evaluacion1) {
        this.evaluacion1 = evaluacion1;
    }

    public Date getEvaluacion2() {
        return evaluacion2;
    }

    public void setEvaluacion2(Date evaluacion2) {
        this.evaluacion2 = evaluacion2;
    }

    public Date getEvaluacion3() {
        return evaluacion3;
    }

    public void setEvaluacion3(Date evaluacion3) {
        this.evaluacion3 = evaluacion3;
    }

    @Override
    public String toString() {
        return "GestionPeriodo [id=" + id + ", gestion=" + gestion + ", periodo=" + periodo + ", inicio_clase="
                + inicio_clase + ", fin_clase=" + fin_clase + ", evaluacion1=" + evaluacion1 + ", evaluacion2="
                + evaluacion2 + ", evaluacion3=" + evaluacion3 + "]";
    }

}
