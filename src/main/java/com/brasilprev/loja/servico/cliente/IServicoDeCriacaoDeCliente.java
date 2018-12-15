package com.brasilprev.loja.servico.cliente;

import com.brasilprev.loja.controller.ConfirmacaoDeSucesso;
import com.brasilprev.loja.controller.cliente.AdicionaClienteHttpDto;

public interface IServicoDeCriacaoDeCliente {
    ConfirmacaoDeSucesso criar(AdicionaClienteHttpDto adicionaClienteHttpDto);
}
