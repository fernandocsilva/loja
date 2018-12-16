package com.brasilprev.loja.controller.produto;

import com.brasilprev.loja.controller.ConfirmacaoDeSucesso;
import com.brasilprev.loja.servico.produto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/v1/produtos")
@Api(value = "Recursos do produto", description = "Operações referentes aos produtos")
public class ProdutoController {
    private IServicoDeConsultaDeProduto servicoDeConsultaDeProduto;
    private IServicoDeCriacaoDeProduto servicoDeCriacaoDeProduto;
    private IServicoDeAtualizacaoDeProduto servicoDeAtualizacaoDeProduto;
    private IServicoDeExclusaoDeProduto servicoDeExclusaoDeProduto;

    @Autowired
    public ProdutoController(IServicoDeConsultaDeProduto servicoDeConsultaDeProduto,
                             IServicoDeCriacaoDeProduto servicoDeCriacaoDeProduto,
                             IServicoDeAtualizacaoDeProduto servicoDeAtualizacaoDeProduto,
                             IServicoDeExclusaoDeProduto servicoDeExclusaoDeProduto) {
        this.servicoDeConsultaDeProduto = servicoDeConsultaDeProduto;
        this.servicoDeCriacaoDeProduto = servicoDeCriacaoDeProduto;
        this.servicoDeAtualizacaoDeProduto = servicoDeAtualizacaoDeProduto;
        this.servicoDeExclusaoDeProduto = servicoDeExclusaoDeProduto;
    }

    @GetMapping
    @ApiOperation(value = "Retorna uma lista com todos os produtos cadastrados")
    public ResponseEntity<List<ProdutoDTO>> obterTodosOsProdutos(){
        List<ProdutoDTO> produtoDTOS = servicoDeConsultaDeProduto.obterTodos();

        return new ResponseEntity<>(produtoDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna o produto com o identificador informado")
    public ResponseEntity<ProdutoDTO> obterProdutoPor(@PathVariable(value = "id") Long id){
        Optional<ProdutoDTO> produtoDTOEncontrado = servicoDeConsultaDeProduto.obterPor(id);

        return produtoDTOEncontrado
                .map((produtoDTO) -> new ResponseEntity<>(produtoDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ApiOperation(value = "Cria um produto")
    public ResponseEntity<ConfirmacaoDeSucesso> criarProduto(AdicionaProdutoHttpDto adicionaProdutoHttpDto){
        ConfirmacaoDeSucesso confirmacaoDeSucesso = servicoDeCriacaoDeProduto.criar(adicionaProdutoHttpDto);

        return new ResponseEntity<>(confirmacaoDeSucesso, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza um produto")
    public ResponseEntity alterarProduto(@PathVariable(value = "id") Long id, AtualizaProdutoHttpDto atualizaProdutoHttpDto){
        servicoDeAtualizacaoDeProduto.atualizar(id, atualizaProdutoHttpDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Exclui um produto")
    public ResponseEntity excluirProduto(@PathVariable(value = "id") Long id){
        servicoDeExclusaoDeProduto.excluir(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}