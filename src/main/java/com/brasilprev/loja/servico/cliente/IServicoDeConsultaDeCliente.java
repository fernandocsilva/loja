package com.brasilprev.loja.servico.cliente;

import java.util.List;

public interface IServicoDeConsultaDeCliente {
    List<ClienteDTO> obterTodos();
    ClienteDTO obterPor(Long id);
}
