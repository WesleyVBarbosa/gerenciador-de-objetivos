package com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Evidencia {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "objetivo_id")
    private Objetivo objetivo;

    private String caminhoImagem;

    @Deprecated
    public Evidencia() {
    }

    public Evidencia(Objetivo objetivo, String caminhoImagem) {
        this.objetivo = objetivo;
        this.caminhoImagem = caminhoImagem;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public int getId() {
        return id;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }
}
