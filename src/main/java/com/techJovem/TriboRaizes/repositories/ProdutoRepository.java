package com.techJovem.TriboRaizes.repositories;

import com.techJovem.TriboRaizes.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
