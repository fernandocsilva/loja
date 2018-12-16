package com.brasilprev.loja.servico.categoria;

import com.brasilprev.loja.infra.repositorios.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
