package com.brasilprev.loja.servico.pedido;

import com.brasilprev.loja.dominio.Cliente;
import com.brasilprev.loja.dominio.Endereco;
import com.brasilprev.loja.dominio.Pedido;
import com.brasilprev.loja.dominio.excecao.ExcecaoDeRegraDeNegocio;
import com.brasilprev.loja.infra.produto.PedidoRepositorio;
import com.brasilprev.loja.servico.cliente.ClienteDTO;
import com.brasilprev.loja.servico.endereco.EnderecoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicoDeConsultaDePedido implements IServicoDeConsultaDePedido {
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    public ServicoDeConsultaDePedido(PedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }

    @Override
    public List<PedidoDTO> obterTodos() {
        List<Pedido> pedidosEncontrados = pedidoRepositorio.findAll();

        List<PedidoDTO> pedidosDTO = pedidosEncontrados.stream().map(this::montarPedidoDTO).collect(Collectors.toList());

        return pedidosDTO;
    }

    @Override
    public PedidoDTO obterPor(Long id) {
        Optional<Pedido> pedidoEncontrado = pedidoRepositorio.findById(id);

        pedidoEncontrado.orElseThrow(() -> new ExcecaoDeRegraDeNegocio("Pedido não encontrado."));

        return montarPedidoDTO(pedidoEncontrado.get());
    }

    private PedidoDTO montarPedidoDTO(Pedido pedido) {
        Cliente cliente = pedido.getCliente();
        ClienteDTO clienteDTO = montarClienteDTO(cliente);

        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.id = pedido.getId();
        pedidoDTO.dataDoPedido = pedido.getDataDoPedido();
        pedidoDTO.statusDoPedido = pedido.getStatusDoPedido();
        pedidoDTO.clienteDTO = clienteDTO;

        return pedidoDTO;
    }

    private ClienteDTO montarClienteDTO(Cliente cliente) {
        Endereco endereco = cliente.getEndereco();

        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.rua = endereco.getRua();
        enderecoDTO.bairro = endereco.getBairro();
        enderecoDTO.cep = endereco.getCep();
        enderecoDTO.cidade = endereco.getCidade();
        enderecoDTO.estado = endereco.getEstado();

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.id = cliente.getId();
        clienteDTO.nome = cliente.getNome();
        clienteDTO.senha = cliente.getSenha();
        clienteDTO.email = cliente.getEmail();
        clienteDTO.enderecoDTO = enderecoDTO;

        return clienteDTO;
    }
}
