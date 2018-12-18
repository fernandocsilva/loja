package com.brasilprev.loja.servico.categoria;

import com.brasilprev.loja.controller.ConfirmacaoDeSucesso;
import com.brasilprev.loja.controller.categoria.AdicionaCategoriaHttpDto;
import com.brasilprev.loja.dominio.Categoria;
import com.brasilprev.loja.infra.repositorios.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoDeCriacaoDeCategoria implements IServicoDeCriacaoDeCategoria {
    private CategoriaRepositorio categoriaRepositorio;

    @Autowired
    public ServicoDeCriacaoDeCategoria(CategoriaRepositorio categoriaRepositorio) {
        this.categoriaRepositorio = categoriaRepositorio;
    }

    @Override
    public ConfirmacaoDeSucesso criar(AdicionaCategoriaHttpDto adicionaCategoriaHttpDto) {
        Categoria categoria = Categoria.criar(adicionaCategoriaHttpDto.nome);
        categoriaRepositorio.save(categoria);

        ConfirmacaoDeSucesso confirmacaoDeSucesso = new ConfirmacaoDeSucesso(categoria.getId());

        return confirmacaoDeSucesso;
    }
}
