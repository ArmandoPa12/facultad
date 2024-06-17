package com.example.facultad.facultad.Entity;

import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "registro")
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "grupo_asignado_id", nullable = true)
    GrupoAsignado grupoasignado;

    private LocalTime tiempo;

    @Temporal(TemporalType.DATE)
    private Date fecha;
    private String lugar;
    private String tipo_check;

    public Registro(Long id, Usuario usuario, GrupoAsignado grupoasignado, LocalTime tiempo, Date fecha, String lugar,
            String tipo_check) {
        this.id = id;
        this.usuario = usuario;
        this.grupoasignado = grupoasignado;
        this.tiempo = tiempo;
        this.fecha = fecha;
        this.lugar = lugar;
        this.tipo_check = tipo_check;
    }

    public Registro(Long id, Usuario usuario, LocalTime tiempo, Date fecha, String lugar, String tipo_check) {
        this.id = id;
        this.usuario = usuario;
        this.tiempo = tiempo;
        this.fecha = fecha;
        this.lugar = lugar;
        this.tipo_check = tipo_check;
    }

    public Registro() {
    }

    public Registro(Long id, Usuario usuario, LocalTime tiempo, Date fecha, String lugar) {
        this.id = id;
        this.usuario = usuario;
        this.tiempo = tiempo;
        this.fecha = fecha;
        this.lugar = lugar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalTime getTiempo() {
        return tiempo;
    }

    public void setTiempo(LocalTime tiempo) {
        this.tiempo = tiempo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return "Registro [id=" + id + ", usuario=" + usuario + ", tiempo=" + tiempo + ", fecha=" + fecha + ", lugar="
                + lugar + "]";
    }

    public String getTipo_check() {
        return tipo_check;
    }

    public void setTipo_check(String tipo_check) {
        this.tipo_check = tipo_check;
    }

    public GrupoAsignado getGrupoasignado() {
        return grupoasignado;
    }

    public void setGrupoasignado(GrupoAsignado grupoasignado) {
        this.grupoasignado = grupoasignado;
    }

}
