package com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Objetivo {

    @Id
    @GeneratedValue
    private int id;

    private String titulo;
    private String descricao;

    @OneToMany
    private List<Objetivo> objetivos;
    @OneToOne
    private StatusEnum statusEnum;
    @OneToMany
    private List<Evidencia> evidencias;
    private BigDecimal percentualConclusao;
    private BigDecimal envolvimento;
    private BigDecimal necessidade;
    private BigDecimal urgencia;

    private void calcularPrioridade() {

    }

    private void alterarStatus() {

    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setObjetivos(List<Objetivo> objetivos) {
        this.objetivos = objetivos;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }

    public void setPercentualConclusao(BigDecimal percentualConclusao) {
        this.percentualConclusao = percentualConclusao;
    }

    public void setEnvolvimento(BigDecimal envolvimento) {
        this.envolvimento = envolvimento;
    }

    public void setNecessidade(BigDecimal necessidade) {
        this.necessidade = necessidade;
    }

    public void setUrgencia(BigDecimal urgencia) {
        this.urgencia = urgencia;
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

    public StatusEnum getStatusEnum() {
        return statusEnum;
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

    public List<Evidencia> getEvidencias() {
        return evidencias;
    }

    public void setEvidencias(List<Evidencia> evidencias) {
        this.evidencias = evidencias;
    }
}
