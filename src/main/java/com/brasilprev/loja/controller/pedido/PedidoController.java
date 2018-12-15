package com.brasilprev.loja.controller.pedido;

import com.brasilprev.loja.controller.ConfirmacaoDeSucesso;
import com.brasilprev.loja.servico.pedido.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v1/pedidos")
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
    public ResponseEntity<List<PedidoDTO>> obterTodosOsPedidos(){
        List<PedidoDTO> pedidosDTO = servicoDeConsultaDePedido.obterTodos();

        return new ResponseEntity<>(pedidosDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> obterPedido(@PathVariable(value = "id") Long id){
        PedidoDTO pedidoDTO = servicoDeConsultaDePedido.obterPor(id);

        return new ResponseEntity<>(pedidoDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ConfirmacaoDeSucesso> criarPedido(AdicionaPedidoHttpDto adicionaPedidoHttpDto){
        ConfirmacaoDeSucesso confirmacaoDeSucesso = servicoDeCriacaoDePedido.criar(adicionaPedidoHttpDto);

        return new ResponseEntity<>(confirmacaoDeSucesso, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity cancelarPedido(@PathVariable(value = "id") Long id, AtualizaPedidoHttpDto atualizaPedidoHttpDto){
        servicoDeAtualizacaoDePedido.atualizar(id, atualizaPedidoHttpDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirPedido(@PathVariable(value = "id") Long id){
        servicoDeExclusaoDePedido.excluir(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
