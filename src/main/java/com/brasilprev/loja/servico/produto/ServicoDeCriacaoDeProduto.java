package com.brasilprev.loja.servico.produto;

import com.brasilprev.loja.controller.AdicionaProdutoHttpDto;
import com.brasilprev.loja.controller.ConfirmacaoDeSucesso;
import com.brasilprev.loja.dominio.Categoria;
import com.brasilprev.loja.dominio.Produto;
import com.brasilprev.loja.dominio.excecao.ExcecaoDeRegraDeNegocio;
import com.brasilprev.loja.infra.produto.CategoriaRepositorio;
import com.brasilprev.loja.infra.produto.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ServicoDeCriacaoDeProduto implements IServicoDeCriacaoDeProduto {

    private final ProdutoRepositorio produtoRepositorio;
    private final CategoriaRepositorio categoriaRepositorio;

    @Autowired
    public ServicoDeCriacaoDeProduto(ProdutoRepositorio produtoRepositorio, CategoriaRepositorio categoriaRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
        this.categoriaRepositorio = categoriaRepositorio;
    }

    @Override
    public ConfirmacaoDeSucesso criar(AdicionaProdutoHttpDto adicionaProdutoHttpDto) {
        Optional<Categoria> categoria = categoriaRepositorio.findById(adicionaProdutoHttpDto.idDaCategoria);

        categoria.orElseThrow(() -> new ExcecaoDeRegraDeNegocio("Categoria não encontrada."));

        Produto produto = Produto.criar(categoria.get(), adicionaProdutoHttpDto.nomeProduto, adicionaProdutoHttpDto.preco,
                adicionaProdutoHttpDto.quantidade, adicionaProdutoHttpDto.descricao, adicionaProdutoHttpDto.urlFoto);

        produtoRepositorio.save(produto);

        ConfirmacaoDeSucesso confirmacaoDeSucesso = new ConfirmacaoDeSucesso(produto.getId());

        return confirmacaoDeSucesso;
    }
}
