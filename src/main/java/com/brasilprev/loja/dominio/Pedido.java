package com.brasilprev.loja.dominio;

import com.brasilprev.loja.dominio.excecao.ExcecaoDeCampoObrigatorio;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataDoPedido;
    private StatusDoPedido statusDoPedido;
    @ManyToOne
    private Cliente cliente;

    private Pedido(LocalDateTime dataDoPedido, StatusDoPedido statusDoPedido, Cliente cliente){
        this.dataDoPedido = dataDoPedido;
        this.statusDoPedido = statusDoPedido;
        this.cliente = cliente;
    }

    public static Pedido criar(Cliente cliente) {
        validarCamposObrigatorios(cliente);

        return new Pedido(LocalDateTime.now(), StatusDoPedido.ABERTO, cliente);
    }

    private static void validarCamposObrigatorios(Cliente cliente) {
        new ExcecaoDeCampoObrigatorio().quandoNulo(cliente, "Informe um cliente para criar um pedido.").entaoDispara();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataDoPedido() {
        return dataDoPedido;
    }

    public StatusDoPedido getStatusDoPedido() {
        return statusDoPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
