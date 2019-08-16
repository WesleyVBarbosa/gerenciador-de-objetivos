package com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity;

import com.github.wesleyvbarbosa.gerenciadorobjetivo.exception.NaoFoiPossivelAdicionarEvidenciaException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Objetivo {

    private static final BigDecimal NUMERO_CAMPOS_PARA_CALCULO_MEDIA_PRIORIDADE = new BigDecimal(4);
    private static final int SCALE = 2;

    @Id
    @GeneratedValue
    private int id;

    private String titulo;
    private String descricao;

    @OneToMany
    private List<Objetivo> objetivos;

    @Enumerated(value = EnumType.STRING)
    private StatusEnum status;

    @OneToMany(mappedBy = "objetivo", cascade = CascadeType.ALL)
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
        this.percentualConclusao = percentualConclusao;
        this.envolvimento = envolvimento;
        this.necessidade = necessidade;
        this.urgencia = urgencia;

        this.status = StatusEnum.EM_ANDAMENTO;
        this.evidencias = new ArrayList<>();
    }

    public List<Evidencia> getEvidencias() {
        return Collections.unmodifiableList(evidencias);
    }

    public void setId(int id) {
        this.id = id;
    }

    public StatusEnum getStatus() {
        return status;
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

    public BigDecimal calcularPrioridade() {
        return getPercentualConclusao()
            .add(getEnvolvimento())
            .add(getNecessidade())
            .add(getUrgencia())
            .divide(NUMERO_CAMPOS_PARA_CALCULO_MEDIA_PRIORIDADE, SCALE, BigDecimal.ROUND_HALF_UP);
    }

    public Objetivo addEvidencia(Evidencia evidencia) {
        if (naoEhPossivelAdicionarEvidencia()) {
            throw new NaoFoiPossivelAdicionarEvidenciaException(this);
        }
        this.evidencias.add(evidencia);
        return this;
    }

    public void alterarStatus(StatusEnum novoStatus) {
        this.status = novoStatus;
    }

    private boolean permiteAdicionarEvidencia() {
        return StatusEnum.permiteAdicionarEvidencia(this.getStatus());
    }

    private boolean naoEhPossivelAdicionarEvidencia() {
        return !permiteAdicionarEvidencia();
    }
}
