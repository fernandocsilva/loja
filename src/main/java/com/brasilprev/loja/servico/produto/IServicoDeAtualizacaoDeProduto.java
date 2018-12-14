package com.brasilprev.loja.servico.produto;

import com.brasilprev.loja.controller.produto.AtualizaProdutoHttpDto;

public interface IServicoDeAtualizacaoDeProduto {
    void atualizar(Long id, AtualizaProdutoHttpDto atualizaProdutoHttpDto);
}
