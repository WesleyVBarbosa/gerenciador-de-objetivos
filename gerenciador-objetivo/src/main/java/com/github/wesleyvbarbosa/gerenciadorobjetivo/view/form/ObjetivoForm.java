package com.github.wesleyvbarbosa.gerenciadorobjetivo.view.form;

import com.github.wesleyvbarbosa.gerenciadorobjetivo.exception.CamposNaoPreenchidosException;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity.Objetivo;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity.StatusEnum;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ObjetivoForm {

    @NotNull
    @NotEmpty
    private String titulo;

    @NotNull
    @NotEmpty
    private String descricao;

    @NotNull
    private List<Objetivo> objetivos;

    @NotNull
    private BigDecimal percentualConclusao;

    @NotNull
    private BigDecimal envolvimento;

    @NotNull
    private BigDecimal necessidade;

    @NotNull
    private BigDecimal urgencia;

    private StatusEnum status;

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

    public Objetivo atualizarObjetivo(Objetivo objetivo) {
        objetivo.setTitulo(this.getTitulo());
        objetivo.setDescricao(this.getDescricao());
        objetivo.setObjetivos(this.getObjetivos());
        objetivo.setEnvolvimento(this.getEnvolvimento());
        objetivo.setNecessidade(this.getNecessidade());
        objetivo.setPercentualConclusao(this.getPercentualConclusao());
        objetivo.setUrgencia(this.getUrgencia());

        return objetivo;
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

    public StatusEnum getStatus() {
        return status;
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
