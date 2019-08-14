package com.github.wesleyvbarbosa.gerenciadorobjetivo.exception;

public class ObjetivoNaoEncontradoException extends BusinessException {

    public ObjetivoNaoEncontradoException() {
        super("Nenhum Objetivo encontrado!");
    }

    public ObjetivoNaoEncontradoException(String message) {
        super(message);
    }

    public ObjetivoNaoEncontradoException(Throwable cause) {
        super(cause);
    }
}
