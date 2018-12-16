package com.brasilprev.loja.servico.produto;

import com.brasilprev.loja.controller.produto.AdicionaProdutoHttpDto;
import com.brasilprev.loja.controller.ConfirmacaoDeSucesso;
import com.brasilprev.loja.dominio.Categoria;
import com.brasilprev.loja.dominio.Produto;
import com.brasilprev.loja.dominio.excecao.ExcecaoDeCampoObrigatorio;
import com.brasilprev.loja.dominio.excecao.ExcecaoDeRegraDeNegocio;
import com.brasilprev.loja.infra.repositorios.CategoriaRepositorio;
import com.brasilprev.loja.infra.repositorios.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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
        new ExcecaoDeCampoObrigatorio()
                .quandoNulo(adicionaProdutoHttpDto.idDaCategoria, "Identificador da categoria é obrigatório.")
                .entaoDispara();

        Optional<Categoria> categoria = categoriaRepositorio.findById(adicionaProdutoHttpDto.idDaCategoria);

        categoria.orElseThrow(() -> new ExcecaoDeRegraDeNegocio("categoria não encontrada."));

        Produto produto = Produto.criar(categoria.get(), adicionaProdutoHttpDto.nomeProduto, adicionaProdutoHttpDto.preco,
                adicionaProdutoHttpDto.quantidade, adicionaProdutoHttpDto.descricao, adicionaProdutoHttpDto.urlFoto);

        produtoRepositorio.save(produto);

        ConfirmacaoDeSucesso confirmacaoDeSucesso = new ConfirmacaoDeSucesso(produto.getId());

        return confirmacaoDeSucesso;
    }
}
