package com.brasilprev.loja.servico.endereco;

import com.brasilprev.loja.controller.endereco.AtualizaEnderecoHttpDto;
import com.brasilprev.loja.dominio.Endereco;
import com.brasilprev.loja.dominio.excecao.ExcecaoDeRegraDeNegocio;
import com.brasilprev.loja.infra.produto.EnderecoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicoDeAtualizacaoDeEndereco implements IServicoDeAtualizacaoDeEndereco {
    private EnderecoRepositorio enderecoRepositorio;

    @Autowired
    public ServicoDeAtualizacaoDeEndereco(EnderecoRepositorio enderecoRepositorio) {
        this.enderecoRepositorio = enderecoRepositorio;
    }

    @Override
    public void atualizar(Long id, AtualizaEnderecoHttpDto atualizaEnderecoHttpDto) {
        Optional<Endereco> enderecoEncontrado = enderecoRepositorio.findById(id);
        enderecoEncontrado.orElseThrow(() -> new ExcecaoDeRegraDeNegocio("Endereço não encontrado"));

        enderecoEncontrado.get().atualizar(atualizaEnderecoHttpDto.rua, atualizaEnderecoHttpDto.bairro,
                atualizaEnderecoHttpDto.cep, atualizaEnderecoHttpDto.cidade, atualizaEnderecoHttpDto.estado);
    }
}
