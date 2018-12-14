package com.brasilprev.loja.builder;

import com.brasilprev.loja.dominio.Cliente;
import com.brasilprev.loja.dominio.Endereco;

public class ClienteBuilder {
    private String nome = "fulano";
    private String email = "fulano@email.com";
    private String senha = "senha123";
    private Endereco endereco = EnderecoBuilder.umEndereco().build();

    private ClienteBuilder(){
    }

    public static ClienteBuilder umCliente() {
        return new ClienteBuilder();
    }

    public Cliente build(){
        return Cliente.criar(nome, email, senha, endereco);
    }
}
