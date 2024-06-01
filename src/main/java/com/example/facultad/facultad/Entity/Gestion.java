package com.example.facultad.facultad.Entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "gestion")
public class Gestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer anio;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fechaIni;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaFin;

    // @OneToMany(mappedBy = "gestion", cascade = CascadeType.ALL, orphanRemoval =
    // true)
    // private List<GestionPeriodo> gestionPeriodos;

    private Gestion() {
    }

    public Gestion(Long id, Integer anio, Date fechaIni, Date fechaFin
    // List<GestionPeriodo> gestionPeriodos
    ) {
        this.id = id;
        this.anio = anio;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        // this.gestionPeriodos = gestionPeriodos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    // public List<GestionPeriodo> getGestionPeriodos() {
    // return gestionPeriodos;
    // }

    // public void setGestionPeriodos(List<GestionPeriodo> gestionPeriodos) {
    // this.gestionPeriodos = gestionPeriodos;
    // }

    @Override
    public String toString() {
        return "Gestion [id=" + id + ", anio=" + anio + ", fechaIni=" + fechaIni + ", fechaFin=" + fechaFin + "]";
        // + ", gestionPeriodos=" + gestionPeriodos + "]";
    }

}
