package com.brasilprev.loja.dominio;


import com.brasilprev.loja.dominio.excecao.ExcecaoDeCampoObrigatorio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rua;
    private String cidade;
    private String bairro;
    private String cep;
    private String estado;

    private Endereco(String rua, String cidade, String bairro, String cep, String estado) {
        this.rua = rua;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.estado = estado;
    }

    public static Endereco criar(String rua, String cidade, String bairro, String cep, String estado){
        validarCamposObrigatorios(rua, cidade, bairro, cep, estado);

        return new Endereco(rua, cidade, bairro, cep, estado);
    }

    private static void validarCamposObrigatorios(String rua, String cidade, String bairro, String cep, String estado) {
        new ExcecaoDeCampoObrigatorio()
                .quandoNuloOuVazio(rua, "Informe uma rua para a criação do endereço")
                .quandoNuloOuVazio(cidade, "Informe uma cidade para a criação do endereço")
                .quandoNuloOuVazio(bairro, "Informe um bairro para a criação do endereço")
                .quandoNuloOuVazio(cep, "Informe um cep para a criação do endereço")
                .quandoNuloOuVazio(estado, "Informe um estado para a criação do endereço")
                .entaoDispara();
    }

    public Long getId() {
        return id;
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

    public void atualizar(String rua, String bairro, String cep, String cidade, String estado) {
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }
}
