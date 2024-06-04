package com.example.facultad.facultad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

// @SpringBootApplication
public class FacultadApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacultadApplication.class, args);

		// SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
		// String base64Key = Encoders.BASE64.encode(key.getEncoded());
		// System.out.println("JWT Secret Key: " + base64Key);
	}

}
