package com.brasilprev.loja.servico.produto;

import com.brasilprev.loja.controller.AdicionaProdutoHttpDto;
import com.brasilprev.loja.controller.ConfirmacaoDeSucesso;

public interface IServicoDeCriacaoDeProduto {
    ConfirmacaoDeSucesso criar(AdicionaProdutoHttpDto adicionaProdutoHttpDto);
}
