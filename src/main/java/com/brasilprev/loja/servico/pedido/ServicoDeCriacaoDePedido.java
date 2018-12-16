package com.brasilprev.loja.servico.pedido;

import com.brasilprev.loja.controller.ConfirmacaoDeSucesso;
import com.brasilprev.loja.controller.pedido.AdicionaPedidoHttpDto;
import com.brasilprev.loja.dominio.Cliente;
import com.brasilprev.loja.dominio.Pedido;
import com.brasilprev.loja.dominio.PedidoItem;
import com.brasilprev.loja.dominio.Produto;
import com.brasilprev.loja.dominio.excecao.ExcecaoDeRegraDeNegocio;
import com.brasilprev.loja.infra.repositorios.ClienteRepositorio;
import com.brasilprev.loja.infra.repositorios.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServicoDeCriacaoDePedido implements IServicoDeCriacaoDePedido {
    private ClienteRepositorio clienteRepositorio;
    private ProdutoRepositorio produtoRepositorio;

    @Autowired
    public ServicoDeCriacaoDePedido(ClienteRepositorio clienteRepositorio, ProdutoRepositorio produtoRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
        this.produtoRepositorio = produtoRepositorio;
    }

    @Override
    public ConfirmacaoDeSucesso criar(AdicionaPedidoHttpDto adicionaPedidoHttpDto) {
        Optional<Cliente> clienteEncontrado = clienteRepositorio.findById(adicionaPedidoHttpDto.idDoCliente);
        clienteEncontrado.orElseThrow(() -> new ExcecaoDeRegraDeNegocio("Cliente não encontrado."));

        Pedido pedido = Pedido.criar(clienteEncontrado.get());

        criarItensDoPedido(adicionaPedidoHttpDto.produtos, pedido);

        return new ConfirmacaoDeSucesso(pedido.getId());
    }

    private void criarItensDoPedido(HashMap<Long, Integer> produtos, Pedido pedido) {
        produtos.forEach((idDoProduto, quantidade) -> {
            Optional<Produto> produto = produtoRepositorio.findById(idDoProduto);
            produto.orElseThrow(() -> new ExcecaoDeRegraDeNegocio("Produto não encontrado."));

            PedidoItem.criar(produto.get(), pedido, quantidade, produto.get().getPreco());
        });
    }
}
