package com.brasilprev.loja.controller;

import com.brasilprev.loja.servico.categoria.CategoriaDTO;

import java.math.BigDecimal;

public class AtualizaProdutoHttpDto {
    public Long idDaCategoria;
    public String nomeProduto;
    public BigDecimal preco;
    public Integer quantidade;
    public String descricao;
    public String urlFoto;
}
