package com.github.wesleyvbarbosa.gerenciadorobjetivo.model.service;

import com.github.wesleyvbarbosa.gerenciadorobjetivo.exception.ObjetivoNaoEncontradoException;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity.Objetivo;
import com.github.wesleyvbarbosa.gerenciadorobjetivo.repository.ObjetivoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ObjetivoServiceTest {

    List<Objetivo> objetivos;

    boolean condicao;

    @Mock
    ObjetivoRepository repository;

    Objetivo objetivo1 = mock(Objetivo.class);

    Objetivo objetivo2 = mock(Objetivo.class);

    @Test
    public void buscarTodos() {
        dadoUmaListaComTodosOsObjetivos();
        quandoAListaNaoTiverElementosVazios();
        deveRetornarUmaNovaListaComTodosOsObjetivos();
    }

    @Test
    public void buscarPorId() {
        dadoUmaListaComTodosOsObjetivos();

    }

    @Test
    public void validacaoPossuiObjetivoVerdadeiro() {
        dadoUmaCondicao();
        quandoPossuirObjetivo();
        aCondicaoDeveSerVerdadeira();

    }

    private void aCondicaoDeveSerVerdadeira() {
        assertTrue(condicao);
    }

    private void quandoPossuirObjetivo() {
        when(objetivo1.getId()).thenReturn(1);
    }

    private void dadoUmaCondicao() {
        condicao = !condicao;
    }

//    @Test
//    public void validacaoPossuiObjetivoFalso() {
//        dadoUmaCondicaoQueConfereSeExisteObjetivo();
//        quandoNaoPossuirObjetivo();
//        deveDarErro();
//
//    }

    @Test
    public void salvar() {
    }

    @Test
    public void alterar() {
    }

    @Test
    public void deletar() {
    }

    @Test
    public void testDeletar() {
    }

    private List deveRetornarUmaNovaListaComTodosOsObjetivos() {
        List novaListaComOsObjetivos = new ArrayList();
        novaListaComOsObjetivos.add(objetivo1);
        novaListaComOsObjetivos.add(objetivo2);

        return novaListaComOsObjetivos;

    }

    private void quandoAListaNaoTiverElementosVazios() {
        objetivos = Arrays.asList(objetivo1, objetivo2);
    }

    private void dadoUmaListaComTodosOsObjetivos() {
        objetivos = repository.findAll();
    }


    @Test(expected= ObjetivoNaoEncontradoException.class)
    public void buscarTodosComListaDeObjetivoVazia() {
        dadoUmaListaComTodosOsObjetivos();
        quandoHouverListaComElementosVazios();
    }

    private void quandoHouverListaComElementosVazios() {
        objetivos = Arrays.asList();
    }
}