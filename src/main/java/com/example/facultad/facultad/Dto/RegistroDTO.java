package com.example.facultad.facultad.Dto;

public class RegistroDTO {
    private Long usuario_id;
    private String lugar;

    public RegistroDTO(Long usuario_id, String lugar) {
        this.usuario_id = usuario_id;
        this.lugar = lugar;
    }

    public RegistroDTO() {
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public RegistroDTO(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    @Override
    public String toString() {
        return "RegistroDTO [usuario_id=" + usuario_id + "]";
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

}
