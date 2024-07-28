package com.example.rssreader.controller;

import com.example.rssreader.model.Categoria;
import com.example.rssreader.service.CategoriaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/categorias")
public class CategoriaControle {
    @Autowired
    private CategoriaServico categoriaServico;

    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaServico.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaServico.findById(id);
        return categoria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Categoria createCategoria(@RequestBody Categoria categoria) {
        return categoriaServico.save(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Long id, @RequestBody Categoria categoriaDetails) {
        Optional<Categoria> categoria = categoriaServico.findById(id);

        if (categoria.isPresent()) {
            Categoria existingCategoria = categoria.get();
            existingCategoria.setNome(categoriaDetails.getNome());
            existingCategoria.setRssUrl(categoriaDetails.getRssUrl());
            return ResponseEntity.ok(categoriaServico.save(existingCategoria));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        if (categoriaServico.findById(id).isPresent()) {
            categoriaServico.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}