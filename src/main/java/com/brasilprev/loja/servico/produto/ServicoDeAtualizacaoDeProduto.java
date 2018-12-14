package com.brasilprev.loja.servico.produto;

import com.brasilprev.loja.controller.AtualizaProdutoHttpDto;
import com.brasilprev.loja.dominio.Categoria;
import com.brasilprev.loja.dominio.Produto;
import com.brasilprev.loja.dominio.excecao.ExcecaoDeRegraDeNegocio;
import com.brasilprev.loja.infra.produto.CategoriaRepositorio;
import com.brasilprev.loja.infra.produto.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ServicoDeAtualizacaoDeProduto implements IServicoDeAtualizacaoDeProduto {
    private final ProdutoRepositorio produtoRepositorio;
    private final CategoriaRepositorio categoriaRepositorio;

    @Autowired
    public ServicoDeAtualizacaoDeProduto(ProdutoRepositorio produtoRepositorio, CategoriaRepositorio categoriaRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
        this.categoriaRepositorio = categoriaRepositorio;
    }

    @Override
    public void atualizar(Long id, AtualizaProdutoHttpDto atualizaProdutoHttpDto) {
        Produto produto = obterProduto(id);
        Categoria categoria = obterCategoria(atualizaProdutoHttpDto);

        produto.atualizar(categoria, atualizaProdutoHttpDto.nomeProduto, atualizaProdutoHttpDto.descricao,
                atualizaProdutoHttpDto.preco, atualizaProdutoHttpDto.quantidade, atualizaProdutoHttpDto.urlFoto);
    }

    private Produto obterProduto(Long id) {
        Optional<Produto> produtoEncontrado = produtoRepositorio.findById(id);
        produtoEncontrado.orElseThrow(() -> new ExcecaoDeRegraDeNegocio("Produto não encontrado."));

        return produtoEncontrado.get();
    }

    private Categoria obterCategoria(AtualizaProdutoHttpDto atualizaProdutoHttpDto) {
        Optional<Categoria> categoria = categoriaRepositorio.findById(atualizaProdutoHttpDto.idDaCategoria);
        categoria.orElseThrow(() -> new ExcecaoDeRegraDeNegocio("Categoria não encontrada."));

        return categoria.get();
    }
}
