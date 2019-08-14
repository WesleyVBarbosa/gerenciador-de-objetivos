package com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity;

public enum StatusEnum {

    CONCLUIDO("concluido"),
    EM_ANDAMENTO( "em andamento"),
    DESCONTINUADO( "descontinuado");

    private String descricao;

    StatusEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
