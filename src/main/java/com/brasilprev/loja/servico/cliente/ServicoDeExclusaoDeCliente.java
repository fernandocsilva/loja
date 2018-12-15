package com.brasilprev.loja.servico.cliente;

import com.brasilprev.loja.infra.produto.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoDeExclusaoDeCliente implements IServicoDeExclusaoDeCliente {
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    public ServicoDeExclusaoDeCliente(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    @Override
    public void excluir(Long id) {
        clienteRepositorio.deleteById(id);
    }
}
