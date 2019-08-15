package com.github.wesleyvbarbosa.gerenciadorobjetivo.exception;

public class NaoFoiPossivelSalvarEvidenciaException extends BusinessException {

    public NaoFoiPossivelSalvarEvidenciaException() {
    }

    public NaoFoiPossivelSalvarEvidenciaException(String message) {
        super(message);
    }

    public NaoFoiPossivelSalvarEvidenciaException(Throwable cause) {
        super(cause);
    }

    public NaoFoiPossivelSalvarEvidenciaException(String message, Throwable cause) {
        super(message, cause);
    }
}
