package com.brasilprev.loja.dominio;

import com.brasilprev.loja.dominio.excecao.ExcecaoDeCampoObrigatorio;

import javax.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private Endereco endereco;

    private Cliente(String nome, String email, String senha, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }

    public static Cliente criar(String nome, String email, String senha, Endereco endereco){
        validarCamposObrigatorios(nome, email, senha);

        return new Cliente(nome, email, senha, endereco);
    }

    private static void validarCamposObrigatorios(String nome, String email, String senha){
        new ExcecaoDeCampoObrigatorio()
                .quandoNulo(nome, "Informe o nome do cliente")
                .quandoNulo(email, "Informe um e-mail do cliente")
                .quandoNulo(senha, "Informe uma senha para o cliente")
                .entaoDispara();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
