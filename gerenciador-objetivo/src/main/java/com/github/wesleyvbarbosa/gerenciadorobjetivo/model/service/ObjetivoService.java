package com.github.wesleyvbarbosa.gerenciadorobjetivo.model.service;

import com.github.wesleyvbarbosa.gerenciadorobjetivo.exception.ObjetivoNaoEncontradoException;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity.Objetivo;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.repository.ObjetivoRepository;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.view.form.ObjetivoForm;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.view.view.ObjetivoView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

@Service
public class ObjetivoService {

    private ObjetivoRepository repository;

    @Autowired
    public ObjetivoService(ObjetivoRepository repository) {
        this.repository = repository;
    }

    public List<ObjetivoView> buscar() {
        List<Objetivo> objetivos = repository.findAll();

        boolean possuiObjetivos = objetivos.stream()
            .allMatch(Objects::nonNull);

        validacaoPossuiObjetivo(possuiObjetivos);

        return objetivos.stream()
            .map(ObjetivoView::new)
            .collect(Collectors.toList());
    }

    public ObjetivoView buscar(int id) {
        Optional<Objetivo> objetivo = repository.findById(id);

        validacaoPossuiObjetivo(objetivo.isPresent());

        return new ObjetivoView(objetivo.get());
    }

    @Transactional
    public ObjetivoView salvar(ObjetivoForm form) {
        Objetivo objetivo = form.converter();

        Objetivo objetivoSalvo = repository.save(objetivo);

        return new ObjetivoView(objetivoSalvo);
    }

    @Transactional
    public void alterar(ObjetivoForm form, int id) {
        Objetivo objetivo = form.converter();
        objetivo.setId(id);
        repository.save(objetivo);
    }

    @Transactional
    public void deletar(int id) {
        repository.deleteById(id);
    }

    @Transactional
    public void deletar(List<ObjetivoForm> objetivosForm) {
        List<Objetivo> objetivos = objetivosForm.stream()
            .map(ObjetivoForm::converter)
            .collect(Collectors.toList());

        repository.deleteInBatch(objetivos);
    }

    private void validacaoPossuiObjetivo(boolean possuiObjetivos) {
        if (!possuiObjetivos) {
            throw new ObjetivoNaoEncontradoException();
        }
    }
}
