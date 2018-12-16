package com.brasilprev.loja.infra.repositorios;

import com.brasilprev.loja.dominio.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
}
