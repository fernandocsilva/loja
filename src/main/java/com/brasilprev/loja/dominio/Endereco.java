package com.brasilprev.loja.dominio;


public class Endereco {
    private String rua;
    private String cidade;
    private String bairro;
    private String cep;
    private String estado;

    public Endereco(String rua, String cidade, String bairro, String cep, String estado) {
        this.rua = rua;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public String getEstado() {
        return estado;
    }
}
