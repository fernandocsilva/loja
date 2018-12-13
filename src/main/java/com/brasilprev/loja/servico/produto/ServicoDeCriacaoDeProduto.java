package com.brasilprev.loja.servico.produto;

import com.brasilprev.loja.controller.AdicionaProdutoHttpDto;
import com.brasilprev.loja.controller.ConfirmacaoDeSucesso;
import com.brasilprev.loja.dominio.Categoria;
import com.brasilprev.loja.dominio.Produto;
import com.brasilprev.loja.infra.produto.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

public class ServicoDeCriacaoDeProduto implements IServicoDeCriacaoDeProduto {

    private final ProdutoRepositorio produtoRepositorio;

    @Autowired
    public ServicoDeCriacaoDeProduto(ProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }

    @Override
    public ConfirmacaoDeSucesso criar(AdicionaProdutoHttpDto adicionaProdutoHttpDto) {
        Categoria categoria = new Categoria(adicionaProdutoHttpDto.categoria.nome);
        Produto produto = Produto.criar(categoria, adicionaProdutoHttpDto.nomeProduto, adicionaProdutoHttpDto.preco,
                adicionaProdutoHttpDto.quantidade, adicionaProdutoHttpDto.descricao, adicionaProdutoHttpDto.urlFoto);

        produtoRepositorio.save(produto);

        ConfirmacaoDeSucesso confirmacaoDeSucesso = new ConfirmacaoDeSucesso(produto.getId());

        return confirmacaoDeSucesso;
    }
}
