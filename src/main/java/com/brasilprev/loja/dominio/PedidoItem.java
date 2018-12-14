package com.brasilprev.loja.dominio;

import com.brasilprev.loja.dominio.excecao.ExcecaoDeCampoObrigatorio;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class PedidoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Produto produto;
    @ManyToOne
    private Pedido pedido;
    private Integer quantidade;
    private BigDecimal valor;
    private BigDecimal total;

    private PedidoItem() {
    }

    private PedidoItem(Produto produto, Pedido pedido, Integer quantidade, BigDecimal valor, BigDecimal total) {
        this.produto = produto;
        this.pedido = pedido;
        this.quantidade = quantidade;
        this.valor = valor;
        this.total = total;
    }

    public static PedidoItem criar(Produto produto, Pedido pedido, Integer quantidade, BigDecimal valor){
        new ExcecaoDeCampoObrigatorio()
                .quandoNulo(produto, "Informe um produto para preencher os itens do pedido")
                .quandoNulo(pedido, "Informe um pedido para compor os itens do pedido")
                .quandoNulo(quantidade, "Informe uma quantidade")
                .quandoNulo(valor, "Informe o valor dos itens")
                .entaoDispara();

        BigDecimal totalCalculado = valor.multiply(BigDecimal.valueOf(quantidade));

        return new PedidoItem(produto, pedido, quantidade, valor, totalCalculado);
    }

    public Long getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
