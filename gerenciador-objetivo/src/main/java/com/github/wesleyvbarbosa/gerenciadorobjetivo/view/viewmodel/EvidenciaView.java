package com.github.wesleyvbarbosa.gerenciadorobjetivo.view.viewmodel;

import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity.Evidencia;

public class EvidenciaView {

    private int id;
    private String caminhoDaImagem;

    public EvidenciaView(Evidencia evidencia) {
        this.id = evidencia.getId();
        this.caminhoDaImagem = evidencia.getCaminhoImagem();
    }

    public int getId() {
        return id;
    }

    public String getCaminhoDaImagem() {
        return caminhoDaImagem;
    }
}
