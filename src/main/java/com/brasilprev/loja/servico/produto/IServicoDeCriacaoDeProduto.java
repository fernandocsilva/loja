package com.brasilprev.loja.servico.produto;

import com.brasilprev.loja.controller.AdicionaProdutoHttpDto;

public interface IServicoDeCriacaoDeProduto {
    void criar(AdicionaProdutoHttpDto adicionaProdutoHttpDto);
}
