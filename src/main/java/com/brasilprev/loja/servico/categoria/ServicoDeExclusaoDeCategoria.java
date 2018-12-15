package com.brasilprev.loja.servico.categoria;

import com.brasilprev.loja.infra.produto.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

public class ServicoDeExclusaoDeCategoria implements IServicoDeExclusaoDeCategoria {
    private CategoriaRepositorio categoriaRepositorio;

    @Autowired
    public ServicoDeExclusaoDeCategoria(CategoriaRepositorio categoriaRepositorio) {
        this.categoriaRepositorio = categoriaRepositorio;
    }

    @Override
    public void excluir(Long id) {
        categoriaRepositorio.deleteById(id);
    }
}
