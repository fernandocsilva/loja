package com.brasilprev.loja.controller.cliente;

import com.brasilprev.loja.controller.ConfirmacaoDeSucesso;
import com.brasilprev.loja.servico.cliente.*;
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
@RequestMapping("/v1/clientes")
@Api(value = "Recursos do cliente", description = "Operações referentes aos clientes")
public class ClienteController {
    private IServicoDeConsultaDeCliente servicoDeConsultaDeCliente;
    private IServicoDeCriacaoDeCliente servicoDeCriacaoDeCliente;
    private IServicoDeAtualizacaoDeCliente servicoDeAtualizacaoDeCliente;
    private IServicoDeExclusaoDeCliente servicoDeExclusaoDeCliente;

    @Autowired
    public ClienteController(IServicoDeConsultaDeCliente servicoDeConsultaDeCliente,
                             IServicoDeCriacaoDeCliente servicoDeCriacaoDeCliente,
                             IServicoDeAtualizacaoDeCliente servicoDeAtualizacaoDeCliente,
                             IServicoDeExclusaoDeCliente servicoDeExclusaoDeCliente) {
        this.servicoDeConsultaDeCliente = servicoDeConsultaDeCliente;
        this.servicoDeCriacaoDeCliente = servicoDeCriacaoDeCliente;
        this.servicoDeAtualizacaoDeCliente = servicoDeAtualizacaoDeCliente;
        this.servicoDeExclusaoDeCliente = servicoDeExclusaoDeCliente;
    }

    @GetMapping
    @ApiOperation(value = "Retorna uma lista com todos os clientes cadastrados")
    public ResponseEntity<List<ClienteDTO>> obterTodosOsClientes(){
        List<ClienteDTO> clientesDTO = servicoDeConsultaDeCliente.obterTodos();

        return new ResponseEntity<>(clientesDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna um cliente com o identificador informado")
    public ResponseEntity<ClienteDTO> obterCliente(@PathVariable(value = "id") Long id){
        Optional<ClienteDTO> clienteDTOEncontrado = servicoDeConsultaDeCliente.obterPor(id);

        return clienteDTOEncontrado
                .map(clienteDTO -> new ResponseEntity<>(clienteDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping
    @ApiOperation(value = "Cria um cliente")
    public ResponseEntity<ConfirmacaoDeSucesso> criarCliente(AdicionaClienteHttpDto adicionaClienteHttpDto){
        ConfirmacaoDeSucesso confirmacaoDeSucesso = servicoDeCriacaoDeCliente.criar(adicionaClienteHttpDto);

        return new ResponseEntity<>(confirmacaoDeSucesso, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza um cliente")
    public ResponseEntity alterarCliente(@PathVariable(value = "id") Long id, AtualizaClienteHttpDto atualizaClienteHttpDto){
        servicoDeAtualizacaoDeCliente.alterar(id, atualizaClienteHttpDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta um cliente")
    public ResponseEntity excluirCliente(@PathVariable(value = "id") Long id){
        servicoDeExclusaoDeCliente.excluir(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
