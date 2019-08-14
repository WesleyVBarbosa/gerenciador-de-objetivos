package com.github.wesleyvbarbosa.gerenciadorobjetivo.view.view;

import com.github.wesleyvbarbosa.gerenciadorobjetivo.exception.CamposNaoPreenchidosException;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity.Objetivo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class ObjetivoView {

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
}