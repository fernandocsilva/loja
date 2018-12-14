package com.brasilprev.loja.infra.produto;

import com.brasilprev.loja.dominio.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
}
