package com.example.facultad.facultad.Dto;

public class LoginDTO {

    private String usuario;
    private String password;

    private LoginDTO() {
    }

    public LoginDTO(String username, String password) {
        this.usuario = username;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String username) {
        this.usuario = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDTO [username=" + usuario + ", password=" + password + "]";
    }

}
