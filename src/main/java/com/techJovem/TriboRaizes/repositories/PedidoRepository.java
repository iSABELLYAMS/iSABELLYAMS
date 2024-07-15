package com.techJovem.TriboRaizes.repositories;

import com.techJovem.TriboRaizes.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
