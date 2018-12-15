package com.brasilprev.loja.dominio;

import com.brasilprev.loja.dominio.excecao.ExcecaoDeCampoObrigatorio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private Categoria() {
    }

    private Categoria(String nome) {
        this.nome = nome;
    }

    public static Categoria criar(String nome){
        new ExcecaoDeCampoObrigatorio().quandoNuloOuVazio(nome, "Informe um nome para a categoria.")
                .entaoDispara();

        return new Categoria(nome);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void atualizar(String nome) {
        this.nome = nome;
    }
}
