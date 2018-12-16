package com.brasilprev.loja.infra.repositorios;

import com.brasilprev.loja.dominio.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {
}
