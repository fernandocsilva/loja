package com.brasilprev.loja.infra.filtros;

import com.brasilprev.loja.dominio.excecao.ExcecaoDeCampoObrigatorio;
import com.brasilprev.loja.dominio.excecao.ExcecaoDeRegraDeNegocio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class TratamentoDeExcecoes {
    @ExceptionHandler({ExcecaoDeRegraDeNegocio.class})
    public final ResponseEntity<ErrosDaApi> tratarExcecaoDeDominio(ExcecaoDeRegraDeNegocio excecao) {
        String mensagemDeErro = excecao.getMessage();

        ErrosDaApi errosDaApi = new ErrosDaApi();
        errosDaApi.mensagem = mensagemDeErro;
        errosDaApi.status = HttpStatus.BAD_REQUEST.value();
        errosDaApi.data = LocalDateTime.now();

        return new ResponseEntity<>(errosDaApi, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ExcecaoDeCampoObrigatorio.class})
    public final ResponseEntity<ErrosDaApi> tratarExcecaoDeCampoObrigatorio(ExcecaoDeCampoObrigatorio excecao) {
        String mensagemDeErro = excecao.toString();

        ErrosDaApi errosDaApi = new ErrosDaApi();
        errosDaApi.mensagem = mensagemDeErro;
        errosDaApi.status = HttpStatus.BAD_REQUEST.value();
        errosDaApi.data = LocalDateTime.now();

        return new ResponseEntity<>(errosDaApi, HttpStatus.BAD_REQUEST);
    }
}
