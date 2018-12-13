package com.brasilprev.loja.controller;

import com.brasilprev.loja.dominio.Produto;
import com.brasilprev.loja.servico.produto.IServicoDeConsultaDeProduto;
import com.brasilprev.loja.servico.produto.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/v1/produtos")
public class ProdutoController {
    private IServicoDeConsultaDeProduto servicoDeConsultaDeProduto;

    @Autowired
    public ProdutoController(IServicoDeConsultaDeProduto servicoDeConsultaDeProduto) {
        this.servicoDeConsultaDeProduto = servicoDeConsultaDeProduto;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> obterTodosOsProdutos(){
        List<ProdutoDTO> produtoDTOS = servicoDeConsultaDeProduto.obterTodos();

        return new ResponseEntity<>(produtoDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> obterProdutoPor(@PathVariable(value = "id") Long id){
        Optional<ProdutoDTO> produtoDTOEncontrado = servicoDeConsultaDeProduto.obterPor(id);

        return produtoDTOEncontrado
                .map((produtoDTO) -> new ResponseEntity<>(produtoDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ConfirmacaoDeSucesso> criarProduto(AdicionaProdutoHttpDto adicionaProdutoHttpDto){

    }
}