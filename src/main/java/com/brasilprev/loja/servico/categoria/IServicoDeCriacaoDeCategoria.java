package com.brasilprev.loja.servico.categoria;

import com.brasilprev.loja.controller.ConfirmacaoDeSucesso;
import com.brasilprev.loja.controller.categoriaProduto.AdicionaCategoriaHttpDto;

public interface IServicoDeCriacaoDeCategoria {
    ConfirmacaoDeSucesso criar(AdicionaCategoriaHttpDto adicionaCategoriaHttpDto);
}
