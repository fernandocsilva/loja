package com.brasilprev.loja.dominio;

import com.brasilprev.loja.builder.EnderecoBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ClienteTest {
    @Test
    public void deveCriarUmCliente(){
        String nomeEsperado = "Fulano";
        String emailEsperado = "fulano@email.com";
        String senhaEsperada = "senha123";
        Endereco enderecoEsperado = EnderecoBuilder.umEndereco().build();

        Cliente clienteCriado = Cliente.criar(nomeEsperado, emailEsperado, senhaEsperada, enderecoEsperado);

        Assert.assertEquals(nomeEsperado, clienteCriado.getNome());
        Assert.assertEquals(emailEsperado, clienteCriado.getEmail());
        Assert.assertEquals(senhaEsperada, clienteCriado.getSenha());
        Assert.assertEquals(enderecoEsperado, clienteCriado.getEndereco());
    }
}
