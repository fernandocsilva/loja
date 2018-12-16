package com.brasilprev.loja.servico.produto;

import com.brasilprev.loja.infra.repositorios.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
