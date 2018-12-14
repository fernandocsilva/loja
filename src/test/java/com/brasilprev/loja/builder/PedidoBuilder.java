package com.brasilprev.loja.builder;

import com.brasilprev.loja.dominio.Cliente;
import com.brasilprev.loja.dominio.Pedido;

public class PedidoBuilder {

    private Cliente cliente = ClienteBuilder.umCliente().build();

    private PedidoBuilder(){
    }

    public static PedidoBuilder umPedido() {
        return new PedidoBuilder();
    }

    public Pedido build(){
        return Pedido.criar(cliente);
    }
}
