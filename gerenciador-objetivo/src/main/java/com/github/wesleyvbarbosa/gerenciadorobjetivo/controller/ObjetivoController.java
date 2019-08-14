package com.github.wesleyvbarbosa.gerenciadorobjetivo.controller;

import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.service.ObjetivoService;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.view.form.ObjetivoForm;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.view.view.ObjetivoView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public List<ObjetivoView> consultarTodos() {
        return service.buscar();
    }

    @GetMapping(path = "/consultar")
    public ObjetivoView consultar(@RequestBody int id) {
        return service.buscar(id);
    }

    @PostMapping(path = "/salvar")
    public HttpStatus salvar(@RequestBody ObjetivoForm form) {
        service.salvar(form);
        return HttpStatus.OK;
    }

    @PostMapping(path = "/alterar")
    public HttpStatus alterar(@RequestBody ObjetivoForm form) {
        service.alterar(form);
        return HttpStatus.OK;
    }

    @PostMapping(path = "/deletar")
    public void deletar(@RequestBody ObjetivoForm form) {
        service.deletar(form);
    }

    @PostMapping(path = "/deletarTodos")
    public void deletarTodos(@RequestBody List<ObjetivoForm> objetivosForm) {
        service.deletar(objetivosForm);
    }

}
