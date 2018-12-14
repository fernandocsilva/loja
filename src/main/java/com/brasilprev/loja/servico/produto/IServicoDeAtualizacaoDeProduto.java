package com.brasilprev.loja.servico.produto;

import com.brasilprev.loja.controller.AtualizaProdutoHttpDto;

public interface IServicoDeAtualizacaoDeProduto {
    void atualizar(Long id, AtualizaProdutoHttpDto atualizaProdutoHttpDto);
}
