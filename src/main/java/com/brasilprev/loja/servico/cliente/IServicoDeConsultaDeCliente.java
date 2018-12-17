package com.brasilprev.loja.servico.cliente;

import java.util.List;
import java.util.Optional;

public interface IServicoDeConsultaDeCliente {
    List<ClienteDTO> obterTodos();
    Optional<ClienteDTO> obterPor(Long id);
}
