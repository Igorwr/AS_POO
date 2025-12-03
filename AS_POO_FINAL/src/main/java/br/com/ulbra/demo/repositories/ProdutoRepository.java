package br.com.ulbra.demo.repositories;

import br.com.ulbra.demo.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Long id(Long id);
}
