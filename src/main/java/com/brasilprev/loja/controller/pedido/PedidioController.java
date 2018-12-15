package com.brasilprev.loja.controller.pedido;

import com.brasilprev.loja.controller.ConfirmacaoDeSucesso;
import com.brasilprev.loja.servico.pedido.IServicoDeConsultaDePedido;
import com.brasilprev.loja.servico.pedido.IServicoDeCriacaoDePedido;
import com.brasilprev.loja.servico.pedido.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/v1/pedidos")
public class PedidioController {
    private IServicoDeConsultaDePedido servicoDeConsultaDePedido;
    private IServicoDeCriacaoDePedido servicoDeCriacaoDePedido;

    @Autowired
    public PedidioController(IServicoDeConsultaDePedido servicoDeConsultaDePedido, IServicoDeCriacaoDePedido servicoDeCriacaoDePedido) {
        this.servicoDeConsultaDePedido = servicoDeConsultaDePedido;
        this.servicoDeCriacaoDePedido = servicoDeCriacaoDePedido;
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
}
