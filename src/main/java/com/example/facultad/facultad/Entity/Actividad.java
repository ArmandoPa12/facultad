package com.example.facultad.facultad.Entity;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "actividad")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;
    @Column(precision = 19, scale = 2)
    private BigDecimal duracion;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha;
    private LocalTime hora_ini;
    private LocalTime hora_fin;

    public Actividad() {
    }

    public Actividad(Long id, String nombre, String direccion, BigDecimal duracion, Date fecha, LocalTime hora_ini,
            LocalTime hora_fin) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.duracion = duracion;
        this.fecha = fecha;
        this.hora_ini = hora_ini;
        this.hora_fin = hora_fin;
    }

    @Override
    public String toString() {
        return "Actividad [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", duracion=" + duracion
                + ", fecha=" + fecha + ", hora_ini=" + hora_ini + ", hora_fin=" + hora_fin + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public BigDecimal getDuracion() {
        return duracion;
    }

    public void setDuracion(BigDecimal duracion) {
        this.duracion = duracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora_ini() {
        return hora_ini;
    }

    public void setHora_ini(LocalTime hora_ini) {
        this.hora_ini = hora_ini;
    }

    public LocalTime getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(LocalTime hora_fin) {
        this.hora_fin = hora_fin;
    }

}
