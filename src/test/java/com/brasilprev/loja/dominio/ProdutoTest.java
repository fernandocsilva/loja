package com.brasilprev.loja.dominio;

import com.brasilprev.loja.builder.CategoriaBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
public class ProdutoTest {
    @Test
    public void deveCriarProduto(){
        String nomeDoProdutoEsperado = "Iphone XS";
        BigDecimal precoEsperado = BigDecimal.valueOf(5500);
        int quantidadeEsperado = 10;
        String descricaoEsperada = "Ótimo celular";
        String urlFotoEsperada = "https://loja.com.br/iphonexs";
        Categoria categoriaEsperada = CategoriaBuilder.umaCategoria().build();

        Produto produtoCriado = new Produto(categoriaEsperada, nomeDoProdutoEsperado, precoEsperado, quantidadeEsperado, descricaoEsperada, urlFotoEsperada);

        Assert.assertEquals(nomeDoProdutoEsperado, produtoCriado.getNomeProduto());
        Assert.assertEquals(precoEsperado, produtoCriado.getPreco());
        Assert.assertEquals(quantidadeEsperado, produtoCriado.getQuantidade());
        Assert.assertEquals(descricaoEsperada, produtoCriado.getDescricao());
        Assert.assertEquals(urlFotoEsperada, produtoCriado.getUrlFoto());
        Assert.assertEquals(categoriaEsperada, produtoCriado.getCategoria());
    }
}
