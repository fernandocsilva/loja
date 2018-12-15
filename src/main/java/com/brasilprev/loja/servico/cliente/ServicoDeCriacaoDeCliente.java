package com.brasilprev.loja.servico.cliente;

import com.brasilprev.loja.controller.ConfirmacaoDeSucesso;
import com.brasilprev.loja.controller.cliente.AdicionaClienteHttpDto;
import com.brasilprev.loja.dominio.Cliente;
import com.brasilprev.loja.dominio.Endereco;
import com.brasilprev.loja.infra.produto.EnderecoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicoDeCriacaoDeCliente implements IServicoDeCriacaoDeCliente {
    private EnderecoRepositorio enderecoRepositorio;

    @Autowired
    public ServicoDeCriacaoDeCliente(EnderecoRepositorio enderecoRepositorio) {
        this.enderecoRepositorio = enderecoRepositorio;
    }

    @Override
    public ConfirmacaoDeSucesso criar(AdicionaClienteHttpDto adicionaClienteHttpDto) {
        Optional<Endereco> enderecoEncontrado = enderecoRepositorio.findById(adicionaClienteHttpDto.idDoEndereco);

        Cliente cliente = Cliente.criar(adicionaClienteHttpDto.nome, adicionaClienteHttpDto.email,
                adicionaClienteHttpDto.senha, enderecoEncontrado.get());

        ConfirmacaoDeSucesso confirmacaoDeSucesso = new ConfirmacaoDeSucesso(cliente.getId());

        return confirmacaoDeSucesso;
    }
}
