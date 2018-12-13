package com.brasilprev.loja.dominio;

import com.brasilprev.loja.builder.CategoriaBuilder;
import com.brasilprev.loja.dominio.excecao.ExcecaoDeCampoObrigatorio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
public class ProdutoTest {

    private String nomeDoProdutoEsperado;
    private BigDecimal precoEsperado;
    private int quantidadeEsperado;
    private String descricaoEsperada;
    private String urlFotoEsperada;
    private Categoria categoriaEsperada;

    @Before
    public void init(){
        nomeDoProdutoEsperado = "Iphone XS";
        precoEsperado = BigDecimal.valueOf(5500);
        quantidadeEsperado = 10;
        descricaoEsperada = "Ótimo celular";
        urlFotoEsperada = "https://loja.com.br/iphonexs";
        categoriaEsperada = CategoriaBuilder.umaCategoria().build();
    }

    @Test
    public void deveCriarProduto(){
        Produto produtoCriado = Produto.criar(categoriaEsperada, nomeDoProdutoEsperado, precoEsperado, quantidadeEsperado, descricaoEsperada, urlFotoEsperada);

        Assert.assertEquals(nomeDoProdutoEsperado, produtoCriado.getNomeProduto());
        Assert.assertEquals(precoEsperado, produtoCriado.getPreco());
        Assert.assertEquals(quantidadeEsperado, produtoCriado.getQuantidade());
        Assert.assertEquals(descricaoEsperada, produtoCriado.getDescricao());
        Assert.assertEquals(urlFotoEsperada, produtoCriado.getUrlFoto());
        Assert.assertEquals(categoriaEsperada, produtoCriado.getCategoria());
    }

    @Test(expected = ExcecaoDeCampoObrigatorio.class)
    public void naoDeveCriarProdutoSemCategoria(){
        Categoria categoria = null;

        Produto.criar(categoria, nomeDoProdutoEsperado, precoEsperado, quantidadeEsperado, descricaoEsperada, urlFotoEsperada);
    }
}
