package com.brasilprev.loja.controller.categoria;

import com.brasilprev.loja.controller.ConfirmacaoDeSucesso;
import com.brasilprev.loja.servico.categoria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/v1/categorias")
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
    public ResponseEntity<List<CategoriaDTO>> obterTodasAsCategorias(){
        List<CategoriaDTO> categorias = servicoDeConsultaDeCategoria.obterTodos();

        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> obterCategoriaPor(@PathVariable(value = "id") Long id){
        Optional<CategoriaDTO> categoriaDTOEncontrada = servicoDeConsultaDeCategoria.obterPor(id);

        return new ResponseEntity<>(categoriaDTOEncontrada.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ConfirmacaoDeSucesso> criarCategoria(AdicionaCategoriaHttpDto adicionaCategoriaHttpDto){
        ConfirmacaoDeSucesso confirmacaoDeSucesso = servicoDeCriacaoDeCategoria.criar(adicionaCategoriaHttpDto);

        return new ResponseEntity<>(confirmacaoDeSucesso, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity alterarCategoria(@PathVariable(value = "id") Long id, AtualizaCategoriaHttpDto atualizaCategoriaHttpDto){
        servicoDeAtualizacaoDeCategoria.atualizar(id, atualizaCategoriaHttpDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirCategoria(@PathVariable(value = "id") Long id){
        servicoDeExclusaoDeCategoria.excluir(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
