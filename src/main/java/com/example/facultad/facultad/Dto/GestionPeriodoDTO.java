package com.example.facultad.facultad.Dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GestionPeriodoDTO {
    private Long periodo_id;
    private Long gestion_id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date inicio_clase;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fin_clase;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date evaluacion1;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date evaluacion2;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date evaluacion3;

    public GestionPeriodoDTO(Long periodo_id, Long gestion_id, Date inicio_clase, Date fin_clase, Date evaluacion1,
            Date evaluacion2, Date evaluacion3) {
        this.periodo_id = periodo_id;
        this.gestion_id = gestion_id;
        this.inicio_clase = inicio_clase;
        this.fin_clase = fin_clase;
        this.evaluacion1 = evaluacion1;
        this.evaluacion2 = evaluacion2;
        this.evaluacion3 = evaluacion3;
    }

    public GestionPeriodoDTO() {
    }

    public Long getPeriodo_id() {
        return periodo_id;
    }

    public void setPeriodo_id(Long periodo_id) {
        this.periodo_id = periodo_id;
    }

    public Long getGestion_id() {
        return gestion_id;
    }

    public void setGestion_id(Long gestion_id) {
        this.gestion_id = gestion_id;
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
        return "GestionPeriodoDTO [periodo_id=" + periodo_id + ", gestion_id=" + gestion_id + ", inicio_clase="
                + inicio_clase + ", fin_clase=" + fin_clase + ", evaluacion1=" + evaluacion1 + ", evaluacion2="
                + evaluacion2 + ", evaluacion3=" + evaluacion3 + "]";
    }

}
