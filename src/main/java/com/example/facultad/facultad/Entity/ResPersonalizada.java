package com.example.facultad.facultad.Entity;

import java.sql.Time;
import java.time.LocalTime;

public class ResPersonalizada {
    private Long id;
    private Time hora_inicio;
    private Time hora_fin;

    public ResPersonalizada() {
    }

    public ResPersonalizada(Long id, Time hora_inicio, Time hora_fin) {
        this.id = id;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
    }

    @Override
    public String toString() {
        return "ResPersonalizada [id=" + id + ", hora_inicio=" + hora_inicio + ", hora_fin=" + hora_fin + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Time getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(Time hora_fin) {
        this.hora_fin = hora_fin;
    }

}
