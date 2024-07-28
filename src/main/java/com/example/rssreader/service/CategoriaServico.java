package com.example.rssreader.service;

import com.example.rssreader.model.Categoria;
import com.example.rssreader.repository.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class CategoriaServico {
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    public List<Categoria> findAll() {
        return categoriaRepositorio.findAll();
    }

    public Optional<Categoria> findById(Long id) {
        return categoriaRepositorio.findById(id);
    }

    public Categoria save(Categoria categoria) {
        return categoriaRepositorio.save(categoria);
    }

    public void deleteById(Long id) {
        categoriaRepositorio.deleteById(id);
    }
}