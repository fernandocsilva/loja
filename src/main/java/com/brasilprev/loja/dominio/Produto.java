package com.brasilprev.loja.dominio;

import java.math.BigDecimal;

public class Produto {
    private Categoria categoria;
    private String nomeProduto;
    private BigDecimal preco;
    private int quantidade;
    private String descricao;
    private String urlFoto;

    public Produto(Categoria categoria, String nomeProduto, BigDecimal preco, int quantidade, String descricao, String urlFoto) {
        this.categoria = categoria;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.urlFoto = urlFoto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUrlFoto() {
        return urlFoto;
    }
}
