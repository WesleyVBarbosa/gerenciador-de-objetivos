package com.github.wesleyvbarbosa.gerenciadorobjetivo.view.form;

import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity.Objetivo;

import lombok.Getter;
import lombok.Setter;

public class ObjetivoForm {

    private String titulo;
    private String descricao;

    @Deprecated
    public ObjetivoForm() {
    }

    public Objetivo converter() {
        Objetivo objetivo = new Objetivo();

        objetivo.setDescricao(this.getDescricao());
        objetivo.setTitulo(this.getTitulo());

        return objetivo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
