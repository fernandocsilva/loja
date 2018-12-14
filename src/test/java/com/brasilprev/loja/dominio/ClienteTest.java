package com.brasilprev.loja.dominio;

import com.brasilprev.loja.builder.EnderecoBuilder;
import com.brasilprev.loja.dominio.excecao.ExcecaoDeCampoObrigatorio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ClienteTest {
    private String nome;
    private String email;
    private String senha;
    private Endereco endereco;

    @Before
    public void Init(){
        nome = "Fulano";
        email = "fulano@email.com";
        senha = "senha123";
        endereco = EnderecoBuilder.umEndereco().build();
    }

    @Test
    public void deveCriarUmCliente(){
        Cliente clienteCriado = Cliente.criar(nome, email, senha, endereco);

        Assert.assertEquals(nome, clienteCriado.getNome());
        Assert.assertEquals(email, clienteCriado.getEmail());
        Assert.assertEquals(senha, clienteCriado.getSenha());
        Assert.assertEquals(endereco, clienteCriado.getEndereco());
    }

    @Test(expected = ExcecaoDeCampoObrigatorio.class)
    public void naoDeveCriarUmClienteSemNome(){
        String nomeVazio = null;

        Cliente clienteCriado = Cliente.criar(nomeVazio, email, senha, endereco);
    }

    @Test(expected = ExcecaoDeCampoObrigatorio.class)
    public void naoDeveCriarUmClienteSemEmail(){
        String emailVazio = null;

        Cliente clienteCriado = Cliente.criar(nome, emailVazio, senha, endereco);
    }

    @Test(expected = ExcecaoDeCampoObrigatorio.class)
    public void naoDeveCriarUmClienteSemSenha(){
        String senhaVazia = null;

        Cliente clienteCriado = Cliente.criar(nome, email, senhaVazia, endereco);
    }
}
