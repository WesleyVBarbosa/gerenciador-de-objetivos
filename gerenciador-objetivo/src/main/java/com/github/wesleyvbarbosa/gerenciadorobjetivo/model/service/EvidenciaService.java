package com.github.wesleyvbarbosa.gerenciadorobjetivo.model.service;

import com.github.wesleyvbarbosa.gerenciadorobjetivo.exception.ObjetivoNaoEncontradoException;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity.Evidencia;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity.Objetivo;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.repository.ObjetivoRepository;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.view.view.EvidenciaView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

@Service
public class EvidenciaService {

    private ObjetivoRepository objetivoRepository;

    @Autowired
    public EvidenciaService(ObjetivoRepository objetivoRepository) {
        this.objetivoRepository = objetivoRepository;
    }

    public List<EvidenciaView> consultarEvidencias(int id) {
        Optional<Objetivo> objetivoRecebido = objetivoRepository.findById(id);
        validacaoPossuiObjetivo(objetivoRecebido.isPresent());

        Objetivo objetivo = objetivoRecebido.get();

        return objetivo.getEvidencias()
            .stream()
            .map(EvidenciaView::new)
            .collect(Collectors.toList());
    }

    @Transactional
    public void salvarEvidencia(List<MultipartFile> arquivos, int id) {
        File pasta = new File("/imagensRecebidas"); // TODO Colocar o pathname no application.properties

        pasta.mkdirs();

        Optional<Objetivo> objetivoRecebido = objetivoRepository.findById(id);
        validacaoPossuiObjetivo(objetivoRecebido.isPresent());
        Objetivo objetivo = objetivoRecebido.get();

        for (MultipartFile arquivo : arquivos) {
            File arquivoRecebido = new File(pasta, Objects.requireNonNull(arquivo.getOriginalFilename()));

            try (FileOutputStream writer = new FileOutputStream(arquivoRecebido)) {
                writer.write(arquivo.getBytes());
                Evidencia evidencia = new Evidencia(objetivo, arquivoRecebido.getAbsolutePath());
                objetivo.addEvidencia(evidencia);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void validacaoPossuiObjetivo(boolean possuiObjetivos) {
        if (!possuiObjetivos) {
            throw new ObjetivoNaoEncontradoException();
        }
    }
}
