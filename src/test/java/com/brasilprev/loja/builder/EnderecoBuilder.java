package com.brasilprev.loja.builder;

import com.brasilprev.loja.dominio.Endereco;

public class EnderecoBuilder {
    private String rua = "rua";
    private String bairro = "bairro";
    private String cidade = "cidade";
    private String estado = "estado";
    private String cep = "cep";

    private EnderecoBuilder(){
    }

    public static EnderecoBuilder umEndereco() {
        return new EnderecoBuilder();
    }

    public Endereco build(){
        return Endereco.criar(rua, cidade, bairro, cep, estado);
    }
}
