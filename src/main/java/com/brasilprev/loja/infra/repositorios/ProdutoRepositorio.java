package com.brasilprev.loja.infra.repositorios;

import com.brasilprev.loja.dominio.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

}
