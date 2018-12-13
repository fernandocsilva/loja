package com.brasilprev.loja.servico.produto;


import java.util.List;
import java.util.Optional;

public interface IServicoDeConsultaDeProduto {
    List<ProdutoDTO> obterTodos();
    Optional<ProdutoDTO> obterPor(Long id);
}
