package com.github.wesleyvbarbosa.gerenciadorobjetivo.model.service;

import com.github.wesleyvbarbosa.gerenciadorobjetivo.exception.NaoFoiPossivelSalvarEvidenciaException;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.exception.ObjetivoNaoEncontradoException;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity.Evidencia;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity.Objetivo;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.repository.ObjetivoRepository;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.view.viewmodel.EvidenciaView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    private static final String MENSAGEM_ERRO_SALVAR_EVIDENCIA = "Não foi possível salvar suas evidências!";
    private String caminhoDiretorio;

    private ObjetivoRepository objetivoRepository;

    @Autowired
    public EvidenciaService(ObjetivoRepository objetivoRepository, @Value("${caminho.diretorio}") String caminho) {
        this.caminhoDiretorio = caminho;
        this.objetivoRepository = objetivoRepository;
    }

    public List<EvidenciaView> consultarEvidencias(int id) {
        Objetivo objetivo = buscaObjetivoJaValidado(id);

        return objetivo.getEvidencias()
            .stream()
            .map(EvidenciaView::new)
            .collect(Collectors.toList());
    }

    @Transactional
    public void salvarEvidencia(List<MultipartFile> arquivos, int id) {
        File pasta = new File(caminhoDiretorio);

        pasta.mkdirs();

        Objetivo objetivo = buscaObjetivoJaValidado(id);

        for (MultipartFile arquivo : arquivos) {
            File arquivoRecebido = new File(pasta, Objects.requireNonNull(arquivo.getOriginalFilename()));

            try (FileOutputStream writer = new FileOutputStream(arquivoRecebido)) {
                writer.write(arquivo.getBytes());
                Evidencia evidencia = new Evidencia(objetivo, arquivoRecebido.getAbsolutePath());
                objetivo.addEvidencia(evidencia);
            } catch (IOException e) {
                throw new NaoFoiPossivelSalvarEvidenciaException(MENSAGEM_ERRO_SALVAR_EVIDENCIA, e);
            }
        }

        objetivoRepository.save(objetivo);
    }

    private Objetivo buscaObjetivoJaValidado(int id) {
        Optional<Objetivo> objetivoRecebido = objetivoRepository.findById(id);
        validacaoPossuiObjetivo(objetivoRecebido.isPresent());
        return objetivoRecebido.get();
    }

    private void validacaoPossuiObjetivo(boolean possuiObjetivos) {
        if (!possuiObjetivos) {
            throw new ObjetivoNaoEncontradoException();
        }
    }
}
