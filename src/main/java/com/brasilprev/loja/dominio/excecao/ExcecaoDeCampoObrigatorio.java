package com.brasilprev.loja.dominio.excecao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class ExcecaoDeCampoObrigatorio extends ExcecaoDeRegraDeNegocio {
    private List<String> erros = new ArrayList<String>();

    public ExcecaoDeCampoObrigatorio() {
        super();
    }

    public ExcecaoDeCampoObrigatorio quandoNulo(Object objeto, String mensagemDeErro){
        if(Objects.isNull(objeto)) {
            erros.add(mensagemDeErro);
        }

        return this;
    }

    public ExcecaoDeCampoObrigatorio quandoNuloOuVazio(String objeto, String mensagemDeErro){
        if(objeto == null || objeto == ""){
            erros.add(mensagemDeErro);
        }

        return this;
    }

    public void entaoDispara(){
        if(!erros.isEmpty()){
            throw this;
        }
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("/n");
        erros.forEach(stringJoiner::add);

        return stringJoiner.toString();
    }
}
