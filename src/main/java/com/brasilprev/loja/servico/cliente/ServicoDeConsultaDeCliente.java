package com.brasilprev.loja.servico.cliente;

import com.brasilprev.loja.dominio.Cliente;
import com.brasilprev.loja.dominio.Endereco;
import com.brasilprev.loja.dominio.excecao.ExcecaoDeRegraDeNegocio;
import com.brasilprev.loja.infra.repositorios.ClienteRepositorio;
import com.brasilprev.loja.servico.endereco.EnderecoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicoDeConsultaDeCliente implements IServicoDeConsultaDeCliente {

    private ClienteRepositorio clienteRepositorio;

    @Autowired
    public ServicoDeConsultaDeCliente(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    @Override
    public List<ClienteDTO> obterTodos() {
        List<Cliente> clientesEncontrados = clienteRepositorio.findAll();

        List<ClienteDTO> clientesDTO = clientesEncontrados.stream().map(this::montarClienteDTO).collect(Collectors.toList());

        return clientesDTO;
    }

    @Override
    public Optional<ClienteDTO> obterPor(Long id) {
        Optional<Cliente> clienteEncontrado = clienteRepositorio.findById(id);

        return clienteEncontrado.map(this::montarClienteDTO);
    }

    private ClienteDTO montarClienteDTO(Cliente cliente) {
        Endereco endereco = cliente.getEndereco();
        EnderecoDTO enderecoDTO = montarEnderecoDTO(endereco);

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.id = cliente.getId();
        clienteDTO.nome = cliente.getNome();
        clienteDTO.email = cliente.getEmail();
        clienteDTO.senha = cliente.getSenha();
        clienteDTO.enderecoDTO = enderecoDTO;

        return clienteDTO;
    }

    private EnderecoDTO montarEnderecoDTO(Endereco endereco) {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.estado = endereco.getEstado();
        enderecoDTO.cidade = endereco.getCidade();
        enderecoDTO.bairro = endereco.getBairro();
        enderecoDTO.rua = endereco.getRua();
        enderecoDTO.cep = endereco.getCep();

        return enderecoDTO;
    }
}
