package com.brasilprev.loja.builder;

import com.brasilprev.loja.dominio.Categoria;
import com.brasilprev.loja.dominio.Produto;

import java.math.BigDecimal;

public class ProdutoBuilder {
    private Categoria categoria = CategoriaBuilder.umaCategoria().build();
    private String nomeDoProduto = "produto";
    private BigDecimal preco = BigDecimal.valueOf(10);
    private Integer quantidade = 2;
    private String descricao = "";
    private String urlFoto = "";

    private ProdutoBuilder(){
    }

    public static ProdutoBuilder umProduto() {
        return new ProdutoBuilder();
    }

    public Produto build(){
        return Produto.criar(categoria, nomeDoProduto, preco, quantidade, descricao, urlFoto);
    }
}
