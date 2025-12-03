package br.com.ulbra.demo.controllers;

import br.com.ulbra.demo.dtos.request.ProdutosRequest;
import br.com.ulbra.demo.entities.Produto;
import br.com.ulbra.demo.services.ProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<Page<Produto>> getProdutos(Pageable pageable){
        return ResponseEntity.ok(this.produtoService.getProdutos(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProduto(@PathVariable Long id){
        return ResponseEntity.ok(this.produtoService.getProduto(id));
    }

    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody ProdutosRequest produtoRequest) {
        Produto produto = this.produtoService.createProduto(produtoRequest);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(produto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduto(@PathVariable Long id, @RequestBody ProdutosRequest produtoRequest){
        this.produtoService.updateProduto(id, produtoRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        this.produtoService.deleteProduto(id);
        return ResponseEntity.ok().build();
    }
}
