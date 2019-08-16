package com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity;

import java.util.ArrayList;
import java.util.List;

public enum StatusEnum {

    CONCLUIDO("concluido"),
    EM_ANDAMENTO("em andamento"),
    DESCONTINUADO("descontinuado");

    private String descricao;

    StatusEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static List<StatusEnum> statusEmQueSePodeAdicionarEvidencias() {
        List<StatusEnum> status = new ArrayList<>();
        status.add(StatusEnum.DESCONTINUADO);
        status.add(StatusEnum.CONCLUIDO);

        return status;
    }

    public static boolean permiteAdicionarEvidencia(StatusEnum status) {
        return statusEmQueSePodeAdicionarEvidencias().contains(status);
    }
}
