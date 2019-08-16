package com.github.wesleyvbarbosa.gerenciadorobjetivo.exception;

import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity.Objetivo;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity.StatusEnum;

import java.text.MessageFormat;

public class NaoFoiPossivelAdicionarEvidenciaException extends BusinessException {

    public NaoFoiPossivelAdicionarEvidenciaException(Objetivo objetivo) {
        super(MessageFormat.format("Só é possível adicionar evidências em objetivos que estão com o status de: {0}, status atual: ", StatusEnum.statusEmQueSePodeAdicionarEvidencias(), objetivo.getStatus()));
    }
}
