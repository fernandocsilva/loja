package com.brasilprev.loja.servico.pedido;

import com.brasilprev.loja.controller.pedido.AtualizaPedidoHttpDto;
import com.brasilprev.loja.dominio.Pedido;
import com.brasilprev.loja.dominio.excecao.ExcecaoDeRegraDeNegocio;
import com.brasilprev.loja.infra.produto.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicoDeAtualizacaoDePedido implements IServicoDeAtualizacaoDePedido {
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    public ServicoDeAtualizacaoDePedido(PedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }

    @Override
    public void atualizar(Long id, AtualizaPedidoHttpDto atualizaPedidoHttpDto) {
        Optional<Pedido> pedidoEncontrado = pedidoRepositorio.findById(id);
        pedidoEncontrado.orElseThrow(() -> new ExcecaoDeRegraDeNegocio("Pedido não encontrado."));

        pedidoEncontrado.get().alterar(atualizaPedidoHttpDto.statusDePedido);
    }
}
