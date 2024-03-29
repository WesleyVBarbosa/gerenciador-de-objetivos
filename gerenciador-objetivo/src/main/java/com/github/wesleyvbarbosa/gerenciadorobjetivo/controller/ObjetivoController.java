package com.github.wesleyvbarbosa.gerenciadorobjetivo.controller;

import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.service.ObjetivoService;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.view.form.ObjetivoForm;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.view.viewmodel.ObjetivoView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/objetivo")
public class ObjetivoController {

    private ObjetivoService service;

    @Autowired
    public ObjetivoController(ObjetivoService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ObjetivoView> consultarTodos() {
        return service.buscar();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ObjetivoView consultar(@PathVariable int id) {
        return service.buscar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ObjetivoView salvar(@RequestBody @Validated ObjetivoForm form) {
        return service.salvar(form);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void alterar(@RequestBody @Validated ObjetivoForm form, @PathVariable int id) {
        service.alterar(form, id);
    }

    @PatchMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void alterarStatus(@RequestBody ObjetivoForm form, @PathVariable int id) {
        service.alterarStatus(form, id);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable int id) {
        service.deletar(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deletarEmLote(@RequestBody List<ObjetivoForm> form) {
        service.deletar(form);
    }
}
