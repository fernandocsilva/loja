package com.brasilprev.loja.controller;

import com.brasilprev.loja.dominio.Categoria;
import com.brasilprev.loja.dominio.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
@RequestMapping("/v1/produtos")
public class ProdutoController {
    @GetMapping
    public ResponseEntity<Produto> obterTodosOsProdutos(){
        String nomeDoProdutoEsperado = "Iphone XS";
        BigDecimal precoEsperado = BigDecimal.valueOf(5500);
        int quantidadeEsperado = 10;
        String descricaoEsperada = "Ótimo celular";
        String urlFotoEsperada = "https://loja.com.br/iphonexs";
        Categoria categoriaEsperada = new Categoria("categoria");

        Produto produtoCriado = new Produto(categoriaEsperada, nomeDoProdutoEsperado, precoEsperado, quantidadeEsperado, descricaoEsperada, urlFotoEsperada);

        return new ResponseEntity<>(produtoCriado, HttpStatus.OK);
    }
}
