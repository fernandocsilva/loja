package com.brasilprev.loja.builder;

import com.brasilprev.loja.dominio.Endereco;

public class EnderecoBuilder {
    private String rua = "rua";
    private String bairro = "rua";
    private String cidade = "rua";
    private String estado = "rua";
    private String cep = "rua";

    private EnderecoBuilder(){
    }

    public static EnderecoBuilder umEndereco() {
        return new EnderecoBuilder();
    }

    public Endereco build(){
        return new Endereco(rua, cidade, bairro, cep, estado);
    }
}
