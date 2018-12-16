package com.brasilprev.loja.controller.pedido;

import com.brasilprev.loja.controller.ConfirmacaoDeSucesso;
import com.brasilprev.loja.servico.pedido.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v1/pedidos")
@Api(value = "Recursos dos pedidos", description = "Operações referentes aos pedidos")
public class PedidoController {
    private IServicoDeConsultaDePedido servicoDeConsultaDePedido;
    private IServicoDeCriacaoDePedido servicoDeCriacaoDePedido;
    private IServicoDeAtualizacaoDePedido servicoDeAtualizacaoDePedido;
    private IServicoDeExclusaoDePedido servicoDeExclusaoDePedido;

    @Autowired
    public PedidoController(IServicoDeConsultaDePedido servicoDeConsultaDePedido,
                            IServicoDeCriacaoDePedido servicoDeCriacaoDePedido,
                            IServicoDeAtualizacaoDePedido servicoDeAtualizacaoDePedido,
                            IServicoDeExclusaoDePedido servicoDeExclusaoDePedido) {
        this.servicoDeConsultaDePedido = servicoDeConsultaDePedido;
        this.servicoDeCriacaoDePedido = servicoDeCriacaoDePedido;
        this.servicoDeAtualizacaoDePedido = servicoDeAtualizacaoDePedido;
        this.servicoDeExclusaoDePedido = servicoDeExclusaoDePedido;
    }

    @GetMapping
    @ApiOperation(value = "Retorna uma lista com todos os pedidos cadastrados")
    public ResponseEntity<List<PedidoDTO>> obterTodosOsPedidos(){
        List<PedidoDTO> pedidosDTO = servicoDeConsultaDePedido.obterTodos();

        return new ResponseEntity<>(pedidosDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna um pedido com o identificador informado")
    public ResponseEntity<PedidoDTO> obterPedido(@PathVariable(value = "id") Long id){
        PedidoDTO pedidoDTO = servicoDeConsultaDePedido.obterPor(id);

        return new ResponseEntity<>(pedidoDTO, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Cria um pedido")
    public ResponseEntity<ConfirmacaoDeSucesso> criarPedido(AdicionaPedidoHttpDto adicionaPedidoHttpDto){
        ConfirmacaoDeSucesso confirmacaoDeSucesso = servicoDeCriacaoDePedido.criar(adicionaPedidoHttpDto);

        return new ResponseEntity<>(confirmacaoDeSucesso, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza um pedido")
    public ResponseEntity alterarPedido(@PathVariable(value = "id") Long id, AtualizaPedidoHttpDto atualizaPedidoHttpDto){
        servicoDeAtualizacaoDePedido.atualizar(id, atualizaPedidoHttpDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Cancela um pedido")
    public ResponseEntity cancelarPedido(@PathVariable(value = "id") Long id){
        servicoDeExclusaoDePedido.excluir(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
