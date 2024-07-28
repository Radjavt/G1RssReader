package com.example.rssreader.repository;

import com.example.rssreader.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByLogin(String login);
}
