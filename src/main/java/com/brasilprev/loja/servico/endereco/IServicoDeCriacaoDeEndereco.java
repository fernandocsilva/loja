package com.brasilprev.loja.servico.endereco;

import com.brasilprev.loja.controller.ConfirmacaoDeSucesso;
import com.brasilprev.loja.controller.endereco.AdicionaEnderecoHttpDto;

public interface IServicoDeCriacaoDeEndereco {
    ConfirmacaoDeSucesso criar(AdicionaEnderecoHttpDto adicionaEnderecoHttpDto);
}
