package com.brasilprev.loja.servico.produto;

import com.brasilprev.loja.servico.categoria.CategoriaDTO;

import java.math.BigDecimal;

public class ProdutoDTO {
    public Long id;
    public CategoriaDTO categoria;
    public String nomeProduto;
    public BigDecimal preco;
    public Integer quantidade;
    public String descricao;
    public String urlFoto;
}
