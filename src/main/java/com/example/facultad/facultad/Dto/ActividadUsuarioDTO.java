package com.example.facultad.facultad.Dto;

public class ActividadUsuarioDTO {
    private Long id;
    private Long usuario_id;
    private Long actividad_id;

    public ActividadUsuarioDTO() {
    }

    public ActividadUsuarioDTO(Long id, Long usuario_id, Long actividad_id) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.actividad_id = actividad_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Long getActividad_id() {
        return actividad_id;
    }

    public void setActividad_id(Long actividad_id) {
        this.actividad_id = actividad_id;
    }

    @Override
    public String toString() {
        return "ActividadUsuarioDTO [id=" + id + ", usuario_id=" + usuario_id + ", actividad_id=" + actividad_id + "]";
    }

}
