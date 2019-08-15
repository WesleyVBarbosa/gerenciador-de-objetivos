package com.github.wesleyvbarbosa.gerenciadorobjetivo.exception;

public class CamposNaoPreenchidosException extends BusinessException {

    public CamposNaoPreenchidosException() {
        super("Os campos obrigatórios não foram preenchidos!");
    }

    public CamposNaoPreenchidosException(String message) {
        super(message);
    }

    public CamposNaoPreenchidosException(Throwable cause) {
        super(cause);
    }

    public CamposNaoPreenchidosException(String message, Throwable cause) {
        super(message, cause);
    }

}
