package com.brasilprev.loja.servico.pedido;

import java.util.List;

public interface IServicoDeConsultaDePedido {
    List<PedidoDTO> obterTodos();
    PedidoDTO obterPor(Long id);
}
