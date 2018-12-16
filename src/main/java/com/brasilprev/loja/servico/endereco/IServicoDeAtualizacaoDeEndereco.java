package com.brasilprev.loja.servico.endereco;

import com.brasilprev.loja.controller.endereco.AtualizaEnderecoHttpDto;

public interface IServicoDeAtualizacaoDeEndereco {
    void atualizar(Long id, AtualizaEnderecoHttpDto atualizaEnderecoHttpDto);
}
