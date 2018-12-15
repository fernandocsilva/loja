package com.brasilprev.loja.servico.pedido;

import com.brasilprev.loja.dominio.StatusDoPedido;
import com.brasilprev.loja.servico.cliente.ClienteDTO;

import java.time.LocalDateTime;

public class PedidoDTO {
    public Long id;
    public LocalDateTime dataDoPedido;
    public StatusDoPedido statusDoPedido;
    public ClienteDTO clienteDTO;
}
