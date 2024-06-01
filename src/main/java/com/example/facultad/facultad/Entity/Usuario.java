package com.example.facultad.facultad.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ci;

    private String nombre;
    private String apellidos;
    private String usuario;
    private String password;
    private String telefono;
    private boolean sexo;
    private boolean rol;

    protected Usuario() {
    }

    public Usuario(Long id, String ci, String nombre, String apellidos, String usuario, String password,
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

    // #region getters
    public String getApellidos() {
        return apellidos;
    }

    public String getCi() {
        return ci;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public boolean getSexo() {
        return sexo;
    }

    public boolean getRol() {
        return rol;
    }
    // #endregion

    // #region setters
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRol(boolean rol) {
        this.rol = rol;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    // #endregion

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", ci='" + ci + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", telefono='" + telefono + '\'' +
                ", sexo=" + sexo +
                ", rol=" + rol +
                '}';
    }

}
