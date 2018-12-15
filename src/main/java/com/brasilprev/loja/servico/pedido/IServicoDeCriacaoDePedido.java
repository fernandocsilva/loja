package com.brasilprev.loja.servico.pedido;

import com.brasilprev.loja.controller.ConfirmacaoDeSucesso;
import com.brasilprev.loja.controller.pedido.AdicionaPedidoHttpDto;

public interface IServicoDeCriacaoDePedido {
    ConfirmacaoDeSucesso criar(AdicionaPedidoHttpDto adicionaPedidoHttpDto);
}
