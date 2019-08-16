package com.github.wesleyvbarbosa.gerenciadorobjetivo.exception;

public class CamposNaoPreenchidosException extends BusinessException {

    public CamposNaoPreenchidosException() {
        super("Os campos obrigatórios não foram preenchidos!");
    }
}
