package com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Objetivo {

    private static final BigDecimal NUMERO_CAMPOS_PARA_CALCULO_MEDIA_PRIORIDADE = new BigDecimal(4);

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

    @Deprecated
    public Objetivo() {
    }

    public Objetivo(String titulo,
                    String descricao,
                    List<Objetivo> objetivos,
                    BigDecimal percentualConclusao,
                    BigDecimal envolvimento,
                    BigDecimal necessidade,
                    BigDecimal urgencia) {

        this.titulo = titulo;
        this.descricao = descricao;
        this.objetivos = objetivos;
        this.statusEnum = StatusEnum.EM_ANDAMENTO;
        this.evidencias = new ArrayList<>();
        this.percentualConclusao = percentualConclusao;
        this.envolvimento = envolvimento;
        this.necessidade = necessidade;
        this.urgencia = urgencia;
    }

    public BigDecimal calcularPrioridade() {
        return getPercentualConclusao()
            .add(getEnvolvimento())
            .add(getNecessidade())
            .add(getUrgencia())
            .divide(NUMERO_CAMPOS_PARA_CALCULO_MEDIA_PRIORIDADE);
    }

    public void alterarStatus(StatusEnum novoStatus) {
        this.statusEnum = novoStatus;
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
        return Collections.unmodifiableList(objetivos);
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
        return Collections.unmodifiableList(evidencias);
    }

    public void setEvidencias(List<Evidencia> evidencias) {
        this.evidencias = evidencias;
    }
}
