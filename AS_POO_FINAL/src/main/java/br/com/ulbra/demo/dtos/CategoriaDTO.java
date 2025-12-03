package br.com.ulbra.demo.dtos;

import java.util.List;

public record CategoriaDTO(Long id, String nome, List<ProdutoDTO> produtos) {
}
