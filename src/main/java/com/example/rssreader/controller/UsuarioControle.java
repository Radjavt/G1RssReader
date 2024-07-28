package com.example.rssreader.controller;

import com.example.rssreader.model.Usuario;
import com.example.rssreader.service.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControle {
    @Autowired
    private UsuarioServico usuarioService;

    @PostMapping("/registrar")
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.registrar(usuario);
    }

}
