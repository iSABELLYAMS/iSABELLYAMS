package com.techJovem.TriboRaizes.services;


import com.techJovem.TriboRaizes.model.Pedido;
import com.techJovem.TriboRaizes.model.Produto;
import com.techJovem.TriboRaizes.repositories.PedidoRepository;
import com.techJovem.TriboRaizes.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido criarPedido(Pedido pedido) {
        Produto produto = produtoRepository.findById(pedido.getProdutoId()).orElseThrow();
        if (produto.getQuantidadeEstoque() >= pedido.getQuantidade()) {
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - pedido.getQuantidade());
            produtoRepository.save(produto);
            return pedidoRepository.save(pedido);
        } else {
            throw new RuntimeException("Estoque insuficiente");
        }
    }
}
