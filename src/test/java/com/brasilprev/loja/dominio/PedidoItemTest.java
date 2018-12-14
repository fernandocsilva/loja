package com.brasilprev.loja.dominio;

import com.brasilprev.loja.builder.PedidoBuilder;
import com.brasilprev.loja.builder.ProdutoBuilder;
import com.brasilprev.loja.dominio.excecao.ExcecaoDeCampoObrigatorio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
public class PedidoItemTest {
    private Produto produto;
    private Pedido pedido;
    private Integer quantidade;
    private BigDecimal valor;

    @Before
    public void Init(){
        produto = ProdutoBuilder.umProduto().build();
        pedido = PedidoBuilder.umPedido().build();
        quantidade = 2;
        valor = BigDecimal.valueOf(100);
    }

    @Test
    public void deveCriarUmPedidoComItens(){
        BigDecimal totalCalculado = valor.multiply(BigDecimal.valueOf(quantidade));

        PedidoItem pedidoItem = PedidoItem.criar(produto, pedido, quantidade, valor);

        Assert.assertEquals(produto, pedidoItem.getProduto());
        Assert.assertEquals(pedido, pedidoItem.getPedido());
        Assert.assertEquals(quantidade, pedidoItem.getQuantidade());
        Assert.assertEquals(valor, pedidoItem.getValor());
        Assert.assertEquals(totalCalculado, pedidoItem.getTotal());
    }

    @Test(expected = ExcecaoDeCampoObrigatorio.class)
    public void naoDeveCriarUmPedidoItemSemPedido(){
        Pedido pedidoNulo = null;

        PedidoItem.criar(produto, pedidoNulo, quantidade, valor);
    }

    @Test(expected = ExcecaoDeCampoObrigatorio.class)
    public void naoDeveCriarUmPedidoItemSemProduto(){
        Produto produtoNulo = null;

        PedidoItem.criar(produtoNulo, pedido, quantidade, valor);
    }

    @Test(expected = ExcecaoDeCampoObrigatorio.class)
    public void naoDeveCriarUmPedidoItemSemQuantidade(){
        Integer quantidadeNula = null;

        PedidoItem.criar(produto, pedido, quantidadeNula, valor);
    }

    @Test(expected = ExcecaoDeCampoObrigatorio.class)
    public void naoDeveCriarUmPedidoItemSemValor(){
        BigDecimal valorNulo = null;

        PedidoItem.criar(produto, pedido, quantidade, valorNulo);
    }
}
