package com.brasilprev.loja.controller.produto;

import com.brasilprev.loja.servico.categoria.CategoriaDTO;

import java.math.BigDecimal;

public class AdicionaProdutoHttpDto {
    public Long idDaCategoria;
    public String nomeProduto;
    public BigDecimal preco;
    public Integer quantidade;
    public String descricao;
    public String urlFoto;
}
