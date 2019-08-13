package com.github.wesleyvbarbosa.gerenciadorobjetivo.controller;

import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.service.ObjetivoService;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.view.form.ObjetivoForm;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.view.view.ObjetivoView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/objetivo")
public class ObjetivoController {

    private ObjetivoService service;

    @Autowired
    public ObjetivoController(ObjetivoService service) {
        this.service = service;
    }

    @PostMapping
    public ObjetivoView salvar(ObjetivoForm formulario) {
        return service.salvar(formulario);
    }

}
