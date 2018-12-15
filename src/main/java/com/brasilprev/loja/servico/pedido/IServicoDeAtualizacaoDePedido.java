package com.brasilprev.loja.servico.pedido;

import com.brasilprev.loja.controller.pedido.AtualizaPedidoHttpDto;

public interface IServicoDeAtualizacaoDePedido {
    void atualizar(Long id, AtualizaPedidoHttpDto atualizaPedidoHttpDto);
}
