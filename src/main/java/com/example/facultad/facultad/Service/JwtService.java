package com.example.facultad.facultad.Service;

public interface JwtService {

    String generateToken(String usuario);

    String getUsernameFromToken(String token);

    boolean validateToken(String token);
}
