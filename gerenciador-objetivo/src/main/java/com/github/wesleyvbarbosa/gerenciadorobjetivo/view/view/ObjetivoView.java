package com.github.wesleyvbarbosa.gerenciadorobjetivo.view.view;

import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity.Objetivo;

public class ObjetivoView {

    private String titulo;
    private String descricao;

    public ObjetivoView(Objetivo objetivo) {
        this.titulo = objetivo.getTitulo();
        this.descricao = objetivo.getDescricao();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }
}