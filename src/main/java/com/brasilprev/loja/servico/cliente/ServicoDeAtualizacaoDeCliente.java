package com.brasilprev.loja.servico.cliente;

import com.brasilprev.loja.controller.cliente.AtualizaClienteHttpDto;
import com.brasilprev.loja.dominio.Cliente;
import com.brasilprev.loja.dominio.excecao.ExcecaoDeRegraDeNegocio;
import com.brasilprev.loja.infra.produto.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicoDeAtualizacaoDeCliente implements IServicoDeAtualizacaoDeCliente {
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    public ServicoDeAtualizacaoDeCliente(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    @Override
    public void alterar(Long id, AtualizaClienteHttpDto atualizaClienteHttpDto) {
        Optional<Cliente> clienteEncontrado = clienteRepositorio.findById(id);

        clienteEncontrado.orElseThrow(() -> new ExcecaoDeRegraDeNegocio("Cliente não encontrado."));

        clienteEncontrado.get().alterar(atualizaClienteHttpDto);
    }
}
