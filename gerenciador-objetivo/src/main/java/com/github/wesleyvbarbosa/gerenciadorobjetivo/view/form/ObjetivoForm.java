package com.github.wesleyvbarbosa.gerenciadorobjetivo.view.form;

import com.github.wesleyvbarbosa.gerenciadorobjetivo.exception.CamposNaoPreenchidosException;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity.Objetivo;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity.StatusEnum;

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
