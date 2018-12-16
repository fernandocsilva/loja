package com.brasilprev.loja.servico.endereco;

import java.util.List;

public interface IServicoDeConsultaDeEndereco {
    List<EnderecoDTO> obterTodos();
    EnderecoDTO obterPor(Long id);
}
