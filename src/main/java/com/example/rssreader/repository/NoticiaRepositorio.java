package com.example.rssreader.repository;

import com.example.rssreader.model.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface NoticiaRepositorio extends JpaRepository<Noticia, Long>{
    List<Noticia> findByCategoriaIdInOrderByDataPublicacaoDesc(List<Long> categoriaIds);
    List<Noticia> findAllByOrderByDataPublicacaoDesc();
    boolean existsByLink(String link);
}
