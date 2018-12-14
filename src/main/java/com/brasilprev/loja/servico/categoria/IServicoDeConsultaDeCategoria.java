package com.brasilprev.loja.servico.categoria;

import com.brasilprev.loja.dominio.Categoria;

import java.util.List;
import java.util.Optional;

public interface IServicoDeConsultaDeCategoria {
    List<CategoriaDTO> obterTodos();
    Optional<CategoriaDTO> obterPor(Long id);
}
