package com.brasilprev.loja.dominio;

import com.brasilprev.loja.dominio.excecao.ExcecaoDeCampoObrigatorio;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Categoria categoria;
    @Column(length = 100)
    private String nomeProduto;
    private BigDecimal preco;
    private Integer quantidade;
    private String descricao;
    private String urlFoto;

    private Produto() {
    }

    private Produto(Categoria categoria, String nomeProduto, BigDecimal preco, Integer quantidade, String descricao, String urlFoto) {
        this.categoria = categoria;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.urlFoto = urlFoto;
    }

    public static Produto criar(Categoria categoria, String nomeProduto, BigDecimal preco, Integer quantidade, String descricao, String urlFoto){
        validarCamposObrigatorios(categoria, nomeProduto, preco, quantidade);

        return new Produto(categoria, nomeProduto, preco, quantidade, descricao, urlFoto);
    }

    private static void validarCamposObrigatorios(Categoria categoria, String nomeProduto, BigDecimal preco, Integer quantidade) {
        new ExcecaoDeCampoObrigatorio()
                .quandoNulo(categoria, "É obrigatório informar uma categoria para o produto.")
                .quandoNuloOuVazio(nomeProduto, "É obrigatório informar um nome para o produto.")
                .quandoNulo(preco, "É obrigatório informar um preço para o produto.")
                .quandoNulo(quantidade, "É obrigatório informar uma quantidade para o produto.")
                .entaoDispara();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public Long getId() { return id; }

    public void atualizar(Categoria categoria, String nomeProduto, String descricao, BigDecimal preco, Integer quantidade, String urlFoto) {
        validarCamposObrigatorios(categoria, nomeProduto, preco, quantidade);

        this.categoria = categoria;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.urlFoto = urlFoto;
    }
}
