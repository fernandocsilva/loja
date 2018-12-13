package com.brasilprev.loja.controller;

import com.brasilprev.loja.servico.categoria.CategoriaDTO;

import java.math.BigDecimal;

public class AdicionaProdutoHttpDto {
    public CategoriaDTO categoria;
    public String nomeProduto;
    public BigDecimal preco;
    public Integer quantidade;
    public String descricao;
    public String urlFoto;
}
