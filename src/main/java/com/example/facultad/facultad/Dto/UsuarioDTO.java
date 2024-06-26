package com.example.facultad.facultad.Dto;

import java.math.BigDecimal;

public class UsuarioDTO {

    private Long id;
    private String ci;
    private String nombre;
    private String apellidos;
    private String usuario;
    private String password;
    private String telefono;
    private boolean sexo;
    private boolean rol;
    private BigDecimal sueldo;
    private BigDecimal sueldo_final;
    private BigDecimal descuento;

    public UsuarioDTO(Long id, String ci, String nombre, String apellidos, String usuario, String password,
            String telefono, boolean sexo, boolean rol, BigDecimal sueldo) {
        this.id = id;
        this.ci = ci;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.password = password;
        this.telefono = telefono;
        this.sexo = sexo;
        this.rol = rol;
        this.sueldo = sueldo;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public BigDecimal getSueldo_final() {
        return sueldo_final;
    }

    public void setSueldo_final(BigDecimal sueldo_final) {
        this.sueldo_final = sueldo_final;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public UsuarioDTO() {

    }

    public UsuarioDTO(Long id, String ci, String nombre, String apellidos, String usuario, String password,
            String telefono, boolean sexo, boolean rol) {
        this.id = id;
        this.ci = ci;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.password = password;
        this.telefono = telefono;
        this.sexo = sexo;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public String getCi() {
        return ci;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getTelefono() {
        return telefono;
    }

    public boolean isSexo() {
        return sexo;
    }

    public boolean isRol() {
        return rol;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public void setRol(boolean rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "UsuarioDTO [id=" + id + ", ci=" + ci + ", nombre=" + nombre + ", apellidos=" + apellidos + ", usuario="
                + usuario + ", password=" + password + ", telefono=" + telefono + ", sexo=" + sexo + ", rol=" + rol
                + "]";
    }

}
