package com.github.wesleyvbarbosa.gerenciadorobjetivo.view.view;

import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity.Objetivo;

import java.math.BigDecimal;
import java.util.List;

public class ObjetivoView {

    private int id;
    private String titulo;
    private String descricao;
    private List<Objetivo> objetivos;
    private BigDecimal percentualConclusao;
    private BigDecimal envolvimento;
    private BigDecimal necessidade;
    private BigDecimal urgencia;

    @Deprecated
    public ObjetivoView() {
    }

    public ObjetivoView(Objetivo objetivo) {
        this.titulo = objetivo.getTitulo();
        this.descricao = objetivo.getDescricao();
        this.objetivos = objetivo.getObjetivos();
        this.percentualConclusao = objetivo.getPercentualConclusao();
        this.envolvimento = objetivo.getEnvolvimento();
        this.necessidade = objetivo.getNecessidade();
        this.urgencia = objetivo.getUrgencia();
        this.id = objetivo.getId();
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Objetivo> getObjetivos() {
        return objetivos;
    }

    public BigDecimal getPercentualConclusao() {
        return percentualConclusao;
    }

    public BigDecimal getEnvolvimento() {
        return envolvimento;
    }

    public BigDecimal getNecessidade() {
        return necessidade;
    }

    public BigDecimal getUrgencia() {
        return urgencia;
    }
}