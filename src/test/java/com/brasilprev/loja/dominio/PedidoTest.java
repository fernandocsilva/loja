package com.brasilprev.loja.dominio;

import com.brasilprev.loja.builder.ClienteBuilder;
import com.brasilprev.loja.dominio.excecao.ExcecaoDeCampoObrigatorio;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RunWith(SpringRunner.class)
public class PedidoTest {
    @Test
    public void deveCriarUmPedido(){
        LocalDateTime dataDoPedido = LocalDateTime.now();
        StatusDoPedido statusDoPedido = StatusDoPedido.ABERTO;
        Cliente cliente = ClienteBuilder.umCliente().build();

        Pedido pedido = Pedido.criar(cliente);

        Assert.assertEquals(dataDoPedido.truncatedTo(ChronoUnit.SECONDS), pedido.getDataDoPedido().truncatedTo(ChronoUnit.SECONDS));
        Assert.assertEquals(statusDoPedido, pedido.getStatusDoPedido());
        Assert.assertEquals(cliente, pedido.getCliente());
    }

    @Test(expected = ExcecaoDeCampoObrigatorio.class)
    public void naoDeveCriarUmPedidoSemCliente(){
        Cliente cliente = null;

        Pedido.criar(cliente);
    }
}
