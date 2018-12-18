package com.brasilprev.loja.controller;

import com.brasilprev.loja.LojaApplication;
import com.brasilprev.loja.builder.ProdutoBuilder;
import com.brasilprev.loja.controller.produto.AdicionaProdutoHttpDto;
import com.brasilprev.loja.dominio.Categoria;
import com.brasilprev.loja.dominio.Produto;
import com.brasilprev.loja.infra.repositorios.CategoriaRepositorio;
import com.brasilprev.loja.infra.repositorios.ProdutoRepositorio;
import com.brasilprev.loja.servico.produto.ProdutoDTO;
import com.fasterxml.classmate.GenericType;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LojaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
public class ProdutoControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    private Categoria categoria;

    @Before
    public void setUp() throws Exception {
        categoria = Categoria.criar("Geladeira");
        this.categoriaRepositorio.save(categoria);
    }

    @Test
    public void deveCriarProduto() {
        AdicionaProdutoHttpDto adicionaProdutoHttpDto = new AdicionaProdutoHttpDto();
        adicionaProdutoHttpDto.idDaCategoria = categoria.getId();
        adicionaProdutoHttpDto.descricao = "descricao";
        adicionaProdutoHttpDto.nomeProduto = "Geladeira";
        adicionaProdutoHttpDto.preco = BigDecimal.valueOf(2599);
        adicionaProdutoHttpDto.quantidade = 2;
        adicionaProdutoHttpDto.urlFoto = "";

        HttpEntity<AdicionaProdutoHttpDto> corpoDaRequisicao = new HttpEntity<AdicionaProdutoHttpDto>(adicionaProdutoHttpDto);

        ResponseEntity<ConfirmacaoDeSucesso> resposta = restTemplate.postForEntity("/v1/produtos", corpoDaRequisicao, ConfirmacaoDeSucesso.class);

        ConfirmacaoDeSucesso confirmacaoDeSucesso = resposta.getBody();

        Optional<Produto> produtoCadastrado = produtoRepositorio.findById(confirmacaoDeSucesso.identificador);
        Assert.assertTrue(produtoCadastrado.isPresent());
        Assert.assertEquals(adicionaProdutoHttpDto.nomeProduto, produtoCadastrado.get().getNomeProduto());
    }

    @Test
    public void deveObterTodosOsProdutos(){
        Produto produto = ProdutoBuilder.umProduto().build();
        this.categoriaRepositorio.save(produto.getCategoria());
        this.produtoRepositorio.save(produto);

        ResponseEntity<ProdutoDTO[]> resposta = restTemplate.getForEntity("/v1/produtos",  ProdutoDTO[].class);

        List<ProdutoDTO> collect = Stream.of(resposta.getBody()).collect(Collectors.toList());

        Assert.assertEquals(collect.size(), 1);
    }
}
