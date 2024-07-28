package com.example.rssreader.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String nome;

        @Column(nullable = false, unique = true)
        private String login;

        @Column(nullable = false)
        private String senha;

        @Column(nullable = false)
        private String email;

        @Column(name = "data_nascimento", nullable = false)
        private LocalDate dataNascimento;

        @Column(nullable = false)
        private boolean ativo;

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                name = "usuario_categorias",
                joinColumns = @JoinColumn(name = "usuario_id"),
                inverseJoinColumns = @JoinColumn(name = "categoria_id")
        )
        private Set<Categoria> categorias = new HashSet<>();
}