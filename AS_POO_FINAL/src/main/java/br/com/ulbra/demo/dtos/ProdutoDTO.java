package br.com.ulbra.demo.dtos;

import java.util.List;

public record ProdutoDTO(Long id, String name, Double preco, Long categoriaID) {
}
