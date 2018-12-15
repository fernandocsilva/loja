package com.brasilprev.loja.controller.cliente;

import com.brasilprev.loja.controller.ConfirmacaoDeSucesso;
import com.brasilprev.loja.servico.cliente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v1/clientes")
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
    public ResponseEntity<List<ClienteDTO>> obterTodosOsClientes(){
        List<ClienteDTO> clientesDTO = servicoDeConsultaDeCliente.obterTodos();

        return new ResponseEntity<>(clientesDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obterCliente(@PathVariable(value = "id") Long id){
        ClienteDTO clienteDTO = servicoDeConsultaDeCliente.obterPor(id);

        return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ConfirmacaoDeSucesso> criarCliente(AdicionaClienteHttpDto adicionaClienteHttpDto){
        ConfirmacaoDeSucesso confirmacaoDeSucesso = servicoDeCriacaoDeCliente.criar(adicionaClienteHttpDto);

        return new ResponseEntity<>(confirmacaoDeSucesso, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity alterarCliente(@PathVariable(value = "id") Long id, AtualizaClienteHttpDto atualizaClienteHttpDto){
        servicoDeAtualizacaoDeCliente.alterar(id, atualizaClienteHttpDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirCliente(@PathVariable(value = "id") Long id){
        servicoDeExclusaoDeCliente.excluir(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
