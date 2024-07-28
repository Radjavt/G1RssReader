package com.example.rssreader.controller;

import com.example.rssreader.model.Noticia;
import com.example.rssreader.service.NoticiaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/noticias")
public class NoticiaControle {
    @Autowired
    private NoticiaServico noticiaService;

    @GetMapping
    public List<Noticia> obterNoticias(@RequestParam Long usuarioId) {
        return noticiaService.obterNoticiasPorPreferenciasDoUsuario(usuarioId);
    }
}
