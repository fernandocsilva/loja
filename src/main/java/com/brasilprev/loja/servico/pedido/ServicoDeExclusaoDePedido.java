package com.brasilprev.loja.servico.pedido;

import com.brasilprev.loja.dominio.Pedido;
import com.brasilprev.loja.dominio.StatusDoPedido;
import com.brasilprev.loja.dominio.excecao.ExcecaoDeRegraDeNegocio;
import com.brasilprev.loja.infra.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicoDeExclusaoDePedido implements IServicoDeExclusaoDePedido {
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    public ServicoDeExclusaoDePedido(PedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }

    @Override
    public void excluir(Long id) {
        Optional<Pedido> pedidoEncontrado = pedidoRepositorio.findById(id);
        pedidoEncontrado.orElseThrow(() -> new ExcecaoDeRegraDeNegocio("Pedido não encontrado."));

        pedidoEncontrado.get().alterar(StatusDoPedido.CANCELADO);
    }
}
