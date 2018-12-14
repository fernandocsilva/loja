package com.brasilprev.loja.servico.produto;

import com.brasilprev.loja.infra.produto.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

public class ServicoDeExclusaoDeProduto implements IServicoDeExclusaoDeProduto {
    private ProdutoRepositorio produtoRepositorio;

    @Autowired
    public ServicoDeExclusaoDeProduto(ProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }

    @Override
    public void excluir(Long id) {
        produtoRepositorio.deleteById(id);
    }
}
