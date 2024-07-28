package com.example.rssreader.service;

import com.example.rssreader.model.Categoria;
import com.example.rssreader.model.Noticia;
import com.example.rssreader.model.Preferencia;
import com.example.rssreader.model.Usuario;
import com.example.rssreader.repository.NoticiaRepositorio;
import com.example.rssreader.repository.PreferenciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class NoticiaServico {
    @Autowired
    private NoticiaRepositorio noticiaRepositorio;

    public List<Noticia> consultarNoticiasPorPreferencias(Usuario usuario) {
        if (usuario.getCategorias().isEmpty()) {
            return noticiaRepositorio.findAll(); // Retorna todas as notícias se o usuário não tiver preferências
        } else {
            Set<Categoria> categorias = usuario.getCategorias();
            return noticiaRepositorio.findByCategoriaIn(categorias);
        }
    }
}