package com.brasilprev.loja.controller.endereco;

import com.brasilprev.loja.controller.ConfirmacaoDeSucesso;
import com.brasilprev.loja.servico.endereco.*;
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
@RequestMapping("/v1/enderecos")
@Api(value = "Recursos dos endereços", description = "Operações referentes aos endereços")
public class EnderecoController {
    private IServicoDeConsultaDeEndereco servicodeConsultaDeEndereco;
    private IServicoDeCriacaoDeEndereco servicoDeCriacaoDeEndereco;
    private IServicoDeAtualizacaoDeEndereco servicoDeAtualizacaoDeEndereco;
    private IServicoDeExclusaoDeEndereco servicoDeExclusaoDeEndereco;

    @Autowired
    public EnderecoController(IServicoDeConsultaDeEndereco servicodeConsultaDeEndereco,
                              IServicoDeCriacaoDeEndereco servicoDeCriacaoDeEndereco,
                              IServicoDeAtualizacaoDeEndereco servicoDeAtualizacaoDeEndereco,
                              IServicoDeExclusaoDeEndereco servicoDeExclusaoDeEndereco) {
        this.servicodeConsultaDeEndereco = servicodeConsultaDeEndereco;
        this.servicoDeCriacaoDeEndereco = servicoDeCriacaoDeEndereco;
        this.servicoDeAtualizacaoDeEndereco = servicoDeAtualizacaoDeEndereco;
        this.servicoDeExclusaoDeEndereco = servicoDeExclusaoDeEndereco;
    }

    @GetMapping
    @ApiOperation(value = "Retorna uma lista com todos os endereços cadastrados")
    public ResponseEntity<List<EnderecoDTO>> obterTodosOsEnderecos(){
        List<EnderecoDTO> enderecosDTO = servicodeConsultaDeEndereco.obterTodos();

        return new ResponseEntity<>(enderecosDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna o endereço com o identificador informado")
    public ResponseEntity<EnderecoDTO> obterEndereco(@PathVariable(value = "id") Long id){
        Optional<EnderecoDTO> enderecoDTOEncontrado = servicodeConsultaDeEndereco.obterPor(id);

        return enderecoDTOEncontrado
                .map(enderecoDTO -> new ResponseEntity<>(enderecoDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping
    @ApiOperation(value = "Cria um endereço")
    public ResponseEntity<ConfirmacaoDeSucesso> criarEndereco(AdicionaEnderecoHttpDto adicionaEnderecoHttpDto){
        ConfirmacaoDeSucesso confirmacaoDeSucesso = servicoDeCriacaoDeEndereco.criar(adicionaEnderecoHttpDto);

        return new ResponseEntity<>(confirmacaoDeSucesso, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza um endereço")
    public ResponseEntity alterarEndereco(@PathVariable(value = "id") Long id, AtualizaEnderecoHttpDto atualizaEnderecoHttpDto){
        servicoDeAtualizacaoDeEndereco.atualizar(id, atualizaEnderecoHttpDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Exclui um endereço")
    public ResponseEntity excluirEndereco(@PathVariable(value = "id") Long id){
        servicoDeExclusaoDeEndereco.excluir(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
