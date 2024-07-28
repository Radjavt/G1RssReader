package com.example.rssreader.service;

import com.example.rssreader.model.Usuario;
import com.example.rssreader.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServico {
    @Autowired
    private UsuarioRepositorio usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario registrar(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuario.setStatus("Ativo");
        return usuarioRepository.save(usuario);
    }

    public Usuario encontrarPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElse(null);
    }

    public Usuario encontrarPorLogin(String login) {
        return usuarioRepository.findByLogin(login).orElse(null);
    }
}