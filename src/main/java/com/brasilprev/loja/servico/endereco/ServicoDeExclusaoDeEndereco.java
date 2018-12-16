package com.brasilprev.loja.servico.endereco;

import com.brasilprev.loja.infra.repositorios.EnderecoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoDeExclusaoDeEndereco implements IServicoDeExclusaoDeEndereco {
    private EnderecoRepositorio enderecoRepositorio;

    @Autowired
    public ServicoDeExclusaoDeEndereco(EnderecoRepositorio enderecoRepositorio) {
        this.enderecoRepositorio = enderecoRepositorio;
    }

    @Override
    public void excluir(Long id) {
        enderecoRepositorio.deleteById(id);
    }
}
