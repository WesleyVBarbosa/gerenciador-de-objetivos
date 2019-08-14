package com.github.wesleyvbarbosa.gerenciadorobjetivo.controller;

import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.service.ObjetivoService;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.view.form.ObjetivoForm;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.view.view.ObjetivoView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping(path = "/consultarTodos")
    @ResponseStatus(HttpStatus.OK)
    public List<ObjetivoView> consultarTodos() {
        return service.buscar();
    }

    @GetMapping(path = "/consultar")
    @ResponseStatus(HttpStatus.OK)
    public ObjetivoView consultar(@RequestBody int id) {
        return service.buscar(id);
    }

    @PostMapping(path = "/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public ObjetivoView salvar(@RequestBody ObjetivoForm form) {
        return service.salvar(form);
    }

    @PostMapping(path = "/alterar")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void alterar(@RequestBody ObjetivoForm form) {
        service.alterar(form);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable int id) {
        service.deletar(id);
    }

    @PostMapping(path = "/deletarEmLote")
    @ResponseStatus(HttpStatus.OK)
    public void deletarEmLote(@RequestBody List<ObjetivoForm> form) {
        service.deletar(form);
    }
}
