package com.brasilprev.loja.servico.pedido;

import com.brasilprev.loja.controller.ConfirmacaoDeSucesso;
import com.brasilprev.loja.controller.pedido.AdicionaPedidoHttpDto;
import com.brasilprev.loja.dominio.Cliente;
import com.brasilprev.loja.dominio.Pedido;
import com.brasilprev.loja.dominio.excecao.ExcecaoDeRegraDeNegocio;
import com.brasilprev.loja.infra.produto.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicoDeCriacaoDePedido implements IServicoDeCriacaoDePedido {
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    public ServicoDeCriacaoDePedido(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    @Override
    public ConfirmacaoDeSucesso criar(AdicionaPedidoHttpDto adicionaPedidoHttpDto) {
        Optional<Cliente> clienteEncontrado = clienteRepositorio.findById(adicionaPedidoHttpDto.idDoCliente);

        clienteEncontrado.orElseThrow(() -> new ExcecaoDeRegraDeNegocio("Cliente não encontrado."));

        Pedido pedido = Pedido.criar(clienteEncontrado.get());

        return new ConfirmacaoDeSucesso(pedido.getId());
    }
}
