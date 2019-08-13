package com.github.wesleyvbarbosa.gerenciadorobjetivo.model.service;

import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity.Objetivo;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.repository.ObjetivoRepository;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.view.form.ObjetivoForm;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.view.view.ObjetivoView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class ObjetivoService {

    private ObjetivoRepository repository;

    @Autowired
    public ObjetivoService(ObjetivoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ObjetivoView salvar(ObjetivoForm formulario) {
        Objetivo objetivo = formulario.converter();

        Objetivo objetivoSalvo = repository.save(objetivo);

        return new ObjetivoView(objetivoSalvo);
    }

    @Transactional
    public void alterar(Objetivo objetivo) {
        repository.save(objetivo);
    }

    public List<Objetivo> buscar() {
        return repository.findAll();
    }

    public void buscar(int id) {
        repository.findById(id);
    }

    @Transactional
    public void deletar(Objetivo objetivo) {
        repository.delete(objetivo);
    }

    @Transactional
    public void deletar(List<Objetivo> objetivos) {
        repository.deleteInBatch(objetivos);
    }
}
