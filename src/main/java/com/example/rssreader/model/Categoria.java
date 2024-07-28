package com.example.rssreader.model;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String rssUrl;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getRssUrl() {
                return rssUrl;
        }

        public void setRssUrl(String rssUrl) {
                this.rssUrl = rssUrl;
        }
}