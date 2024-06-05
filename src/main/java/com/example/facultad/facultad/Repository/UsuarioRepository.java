package com.example.facultad.facultad.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.facultad.facultad.Entity.Usuario;

@EnableJpaRepositories
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findOneByUsuarioAndPassword(String username, String password);

    Usuario findByUsuario(String username);

    Optional<Usuario> findById(Long id);
}
