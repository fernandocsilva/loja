package com.brasilprev.loja.infra.repositorios;

import com.brasilprev.loja.dominio.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepositorio extends JpaRepository<Endereco, Long> {
}
