package com.brasilprev.loja.servico.endereco;

import java.util.List;
import java.util.Optional;

public interface IServicoDeConsultaDeEndereco {
    List<EnderecoDTO> obterTodos();
    Optional<EnderecoDTO> obterPor(Long id);
}
