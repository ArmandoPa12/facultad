package com.example.facultad.facultad.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "actividad_usuario")
public class ActividadUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "actividad_id", nullable = false)
    Actividad actividad;

    public ActividadUsuario() {
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

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public ActividadUsuario(Long id, Usuario usuario, Actividad actividad) {
        this.id = id;
        this.usuario = usuario;
        this.actividad = actividad;
    }

    @Override
    public String toString() {
        return "ActividadUsuario [id=" + id + ", usuario=" + usuario + ", actividad=" + actividad + "]";
    }

}
