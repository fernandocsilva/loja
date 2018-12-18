package com.brasilprev.loja.servico.categoria;

import com.brasilprev.loja.controller.categoriaProduto.AtualizaCategoriaHttpDto;

public interface IServicoDeAtualizacaoDeCategoria {
    void atualizar(Long id, AtualizaCategoriaHttpDto atualizaCategoriaHttpDto);
}
