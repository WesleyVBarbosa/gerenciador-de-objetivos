package com.github.wesleyvbarbosa.gerenciadorobjetivo.controller;

import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.service.EvidenciaService;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.view.viewmodel.EvidenciaView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/evidencia")
public class EvidenciaController {

    private EvidenciaService service;

    @Autowired
    public EvidenciaController(EvidenciaService service) {
        this.service = service;
    }

    @PostMapping(path = "/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestPart("arquivo") List<MultipartFile> arquivos, @PathVariable int id) {
        service.salvarEvidencia(arquivos, id);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<EvidenciaView> consultarEvidencias(@PathVariable int id) {
        return service.consultarEvidencias(id);
    }
}
