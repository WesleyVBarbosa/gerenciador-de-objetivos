package com.github.wesleyvbarbosa.gerenciadorobjetivo.view.form;

import com.github.wesleyvbarbosa.gerenciadorobjetivo.exception.CamposNaoPreenchidosException;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity.Objetivo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class ObjetivoForm {

    private String titulo;
    private String descricao;
    private List<Objetivo> objetivos;
    private BigDecimal percentualConclusao;
    private BigDecimal envolvimento;
    private BigDecimal necessidade;
    private BigDecimal urgencia;

    @Deprecated
    public ObjetivoForm() {
    }

    public Objetivo converter() {
        validaSeCamposObrigatoriosEstaoPreenchidos();
        return new Objetivo(getTitulo(),
                            getDescricao(),
                            getObjetivos(),
                            getPercentualConclusao(),
                            getEnvolvimento(),
                            getNecessidade(),
                            getUrgencia());
    }

    private void validaSeCamposObrigatoriosEstaoPreenchidos() {
        boolean todosOsCamposPreenchidos = Stream.of(titulo,
                                                     descricao,
                                                     percentualConclusao,
                                                     envolvimento,
                                                     necessidade,
                                                     urgencia)
            .allMatch(Objects::nonNull);

        if (!todosOsCamposPreenchidos) {
            throw new CamposNaoPreenchidosException();
        }
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

    public List<Objetivo> getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(List<Objetivo> objetivos) {
        this.objetivos = objetivos;
    }

    public BigDecimal getPercentualConclusao() {
        return percentualConclusao;
    }

    public void setPercentualConclusao(BigDecimal percentualConclusao) {
        this.percentualConclusao = percentualConclusao;
    }

    public BigDecimal getEnvolvimento() {
        return envolvimento;
    }

    public void setEnvolvimento(BigDecimal envolvimento) {
        this.envolvimento = envolvimento;
    }

    public BigDecimal getNecessidade() {
        return necessidade;
    }

    public void setNecessidade(BigDecimal necessidade) {
        this.necessidade = necessidade;
    }

    public BigDecimal getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(BigDecimal urgencia) {
        this.urgencia = urgencia;
    }
}
