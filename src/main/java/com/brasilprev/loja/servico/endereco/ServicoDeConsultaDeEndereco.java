package com.brasilprev.loja.servico.endereco;

import com.brasilprev.loja.dominio.Endereco;
import com.brasilprev.loja.dominio.excecao.ExcecaoDeRegraDeNegocio;
import com.brasilprev.loja.infra.repositorios.EnderecoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicoDeConsultaDeEndereco implements IServicoDeConsultaDeEndereco {
    private EnderecoRepositorio enderecoRepositorio;

    @Autowired
    public ServicoDeConsultaDeEndereco(EnderecoRepositorio enderecoRepositorio) {
        this.enderecoRepositorio = enderecoRepositorio;
    }

    @Override
    public List<EnderecoDTO> obterTodos() {
        List<Endereco> enderecosEncontrados = enderecoRepositorio.findAll();

        List<EnderecoDTO> enderecosDTO = enderecosEncontrados.stream()
                .map(this::montarEnderecoDTO).collect(Collectors.toList());

        return enderecosDTO;
    }

    @Override
    public Optional<EnderecoDTO> obterPor(Long id) {
        Optional<Endereco> enderecoEncontrado = enderecoRepositorio.findById(id);

        return enderecoEncontrado.map(this::montarEnderecoDTO);
    }

    private EnderecoDTO montarEnderecoDTO(Endereco endereco) {
        EnderecoDTO enderecoDTO = new EnderecoDTO();

        enderecoDTO.id = endereco.getId();
        enderecoDTO.cep = endereco.getCep();
        enderecoDTO.rua = endereco.getRua();
        enderecoDTO.bairro = endereco.getBairro();
        enderecoDTO.cidade = endereco.getCidade();
        enderecoDTO.estado = endereco.getEstado();

        return enderecoDTO;
    }
}
