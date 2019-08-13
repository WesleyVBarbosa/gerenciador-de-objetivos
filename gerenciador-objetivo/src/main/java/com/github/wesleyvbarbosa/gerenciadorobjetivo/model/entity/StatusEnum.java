package com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public enum StatusEnum {

    CONCLUIDO(1, "concluido"),
    EM_ANDAMENTO(2, "em andamento"),
    DESCONTINUADO(3, "descontinuado");


    private String descricao;
    @Id
    private int id;

    StatusEnum(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
