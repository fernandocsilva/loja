package com.brasilprev.loja.servico.pedido;

import java.util.List;
import java.util.Optional;

public interface IServicoDeConsultaDePedido {
    List<PedidoDTO> obterTodos();
    Optional<PedidoDTO> obterPor(Long id);
}
