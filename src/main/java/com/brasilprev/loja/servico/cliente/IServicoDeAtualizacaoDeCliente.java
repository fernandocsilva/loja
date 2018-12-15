package com.brasilprev.loja.servico.cliente;

import com.brasilprev.loja.controller.cliente.AtualizaClienteHttpDto;

public interface IServicoDeAtualizacaoDeCliente {
    void alterar(Long id, AtualizaClienteHttpDto atualizaClienteHttpDto);
}
