package com.brasilprev.loja.servico.pedido;

import com.brasilprev.loja.infra.produto.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

public class ServicoDeExclusaoDePedido implements IServicoDeExclusaoDePedido {
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    public ServicoDeExclusaoDePedido(PedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }

    @Override
    public void excluir(Long id) {
        pedidoRepositorio.deleteById(id);
    }
}
