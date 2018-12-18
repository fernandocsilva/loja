package com.brasilprev.loja.controller.categoriaProduto;

import com.brasilprev.loja.controller.ConfirmacaoDeSucesso;
import com.brasilprev.loja.servico.categoria.*;
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
@RequestMapping("/v1/categorias")
@Api(value = "Recursos da categoria", description = "Operações referente às categorias")
public class CategoriaController {
    private IServicoDeConsultaDeCategoria servicoDeConsultaDeCategoria;
    private IServicoDeCriacaoDeCategoria servicoDeCriacaoDeCategoria;
    private IServicoDeAtualizacaoDeCategoria servicoDeAtualizacaoDeCategoria;
    private IServicoDeExclusaoDeCategoria servicoDeExclusaoDeCategoria;

    @Autowired
    public CategoriaController(IServicoDeConsultaDeCategoria servicoDeConsultaDeCategoria,
                               IServicoDeCriacaoDeCategoria servicoDeCriacaoDeCategoria,
                               IServicoDeAtualizacaoDeCategoria servicoDeAtualizacaoDeCategoria,
                               IServicoDeExclusaoDeCategoria servicoDeExclusaoDeCategoria) {
        this.servicoDeConsultaDeCategoria = servicoDeConsultaDeCategoria;
        this.servicoDeCriacaoDeCategoria = servicoDeCriacaoDeCategoria;
        this.servicoDeAtualizacaoDeCategoria = servicoDeAtualizacaoDeCategoria;
        this.servicoDeExclusaoDeCategoria = servicoDeExclusaoDeCategoria;
    }

    @GetMapping
    @ApiOperation(value = "Retorna uma lista com todas as categorias cadastradas")
    public ResponseEntity<List<CategoriaDTO>> obterTodasAsCategorias(){
        List<CategoriaDTO> categorias = servicoDeConsultaDeCategoria.obterTodos();

        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna a categoria com o identificador informado")
    public ResponseEntity<CategoriaDTO> obterCategoriaPor(@PathVariable(value = "id") Long id){
        Optional<CategoriaDTO> categoriaDTOEncontrada = servicoDeConsultaDeCategoria.obterPor(id);

        return categoriaDTOEncontrada
                .map(categoriaDTO -> new ResponseEntity<>(categoriaDTO, HttpStatus.OK))
                .orElseGet(() ->  new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping
    @ApiOperation(value = "Cria uma categoria")
    public ResponseEntity<ConfirmacaoDeSucesso> criarCategoria(AdicionaCategoriaHttpDto adicionaCategoriaHttpDto){
        ConfirmacaoDeSucesso confirmacaoDeSucesso = servicoDeCriacaoDeCategoria.criar(adicionaCategoriaHttpDto);

        return new ResponseEntity<>(confirmacaoDeSucesso, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza um categoria")
    public ResponseEntity alterarCategoria(@PathVariable(value = "id") Long id, AtualizaCategoriaHttpDto atualizaCategoriaHttpDto){
        servicoDeAtualizacaoDeCategoria.atualizar(id, atualizaCategoriaHttpDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Exclui uma categoria")
    public ResponseEntity excluirCategoria(@PathVariable(value = "id") Long id){
        servicoDeExclusaoDeCategoria.excluir(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
