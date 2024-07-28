package com.example.rssreader.repository;

import com.example.rssreader.model.Preferencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface PreferenciaRepositorio extends JpaRepository<Preferencia, Long>  {
    List<Preferencia> findByUsuarioId(Long usuarioId);
}