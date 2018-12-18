package com.brasilprev.loja.servico.categoria;

import com.brasilprev.loja.controller.categoria.AtualizaCategoriaHttpDto;
import com.brasilprev.loja.dominio.Categoria;
import com.brasilprev.loja.dominio.excecao.ExcecaoDeRegraDeNegocio;
import com.brasilprev.loja.infra.repositorios.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicoDeAtualizacaoDeCategoria implements IServicoDeAtualizacaoDeCategoria {
    private CategoriaRepositorio categoriaRepositorio;

    @Autowired
    public ServicoDeAtualizacaoDeCategoria(CategoriaRepositorio categoriaRepositorio) {
        this.categoriaRepositorio = categoriaRepositorio;
    }

    @Override
    public void atualizar(Long id, AtualizaCategoriaHttpDto atualizaCategoriaHttpDto) {
        Optional<Categoria> categoria = categoriaRepositorio.findById(id);

        categoria.orElseThrow(() -> new ExcecaoDeRegraDeNegocio("categoria não encontrada."));

        categoria.get().atualizar(atualizaCategoriaHttpDto.nome);

        categoriaRepositorio.save(categoria.get());
    }
}
