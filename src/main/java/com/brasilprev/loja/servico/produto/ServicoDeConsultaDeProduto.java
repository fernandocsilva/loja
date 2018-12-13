package com.brasilprev.loja.servico.produto;

import com.brasilprev.loja.dominio.Produto;
import com.brasilprev.loja.infra.produto.ProdutoRepositorio;
import com.brasilprev.loja.servico.categoria.CategoriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicoDeConsultaDeProduto implements IServicoDeConsultaDeProduto {

    private final ProdutoRepositorio produtoRepositorio;

    @Autowired
    public ServicoDeConsultaDeProduto(ProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProdutoDTO> obterTodos() {
        List<Produto> produtos = produtoRepositorio.findAll();

        List<ProdutoDTO> produtosDTO = produtos.stream().map(this::montarProdutoDTO).collect(Collectors.toList());

        return produtosDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProdutoDTO> obterPor(Long id) {
        Optional<Produto> produtoEncontrado = produtoRepositorio.findById(id);

        return produtoEncontrado.map(this::montarProdutoDTO);
    }

    private ProdutoDTO montarProdutoDTO(Produto produto) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.nome = produto.getCategoria().getNome();

        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.nomeProduto = produto.getNomeProduto();
        produtoDTO.categoria = categoriaDTO;
        produtoDTO.descricao = produto.getDescricao();
        produtoDTO.preco = produto.getPreco();
        produtoDTO.quantidade = produto.getQuantidade();
        produtoDTO.urlFoto = produto.getUrlFoto();

        return produtoDTO;
    }
}
