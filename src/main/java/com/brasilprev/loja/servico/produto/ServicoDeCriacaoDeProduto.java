package com.brasilprev.loja.servico.produto;

import com.brasilprev.loja.controller.AdicionaProdutoHttpDto;
import com.brasilprev.loja.dominio.Produto;
import com.brasilprev.loja.infra.produto.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

public class ServicoDeCriacaoDeProduto implements IServicoDeCriacaoDeProduto {

    private final ProdutoRepositorio produtoRepositorio;

    @Autowired
    public ServicoDeConsultaDeProduto(ProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }

    @Override
    public void criar(AdicionaProdutoHttpDto adicionaProdutoHttpDto) {
        Produto produto = Produto.criar(adicionaProdutoHttpDto.categoria, adicionaProdutoHttpDto.nomeProduto, adicionaProdutoHttpDto.preco,
                adicionaProdutoHttpDto.quantidade, adicionaProdutoHttpDto.descricao, adicionaProdutoHttpDto.urlFoto);

        produtoRepositorio.save(produto);
    }
}
