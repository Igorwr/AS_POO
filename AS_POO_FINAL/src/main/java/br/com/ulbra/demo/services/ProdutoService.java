package br.com.ulbra.demo.services;

import br.com.ulbra.demo.dtos.request.ProdutosRequest;
import br.com.ulbra.demo.entities.Categoria;
import br.com.ulbra.demo.entities.Produto;
import br.com.ulbra.demo.repositories.CategoriaRepository;
import br.com.ulbra.demo.repositories.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public Produto getProduto(Long id){
        return produtoRepository.findById(id).orElseThrow();
    }

    public Page<Produto> getProdutos(Pageable pageable){
        return this.produtoRepository.findAll(pageable);
    }

    public Produto createProduto(ProdutosRequest produtosRequest){
        Categoria categoria = categoriaRepository.findById(produtosRequest.getCategoriaId()).orElseThrow();

        Produto produto = new Produto();

        produto.setName(produtosRequest.getName());
        produto.setPreco(produtosRequest.getPreco());
        produto.setCategoria(categoria);

        return produtoRepository.save(produto);
    }

    public void updateProduto(Long id, ProdutosRequest request){
        Produto produto = produtoRepository.getReferenceById(id);

        produto.setName(request.getName());
        produto.setPreco(request.getPreco());
        Categoria categoria = categoriaRepository.findById(request.getCategoriaId())
                .orElseThrow();
        produto.setCategoria(categoria);


        produtoRepository.save(produto);
    }



    public void deleteProduto(Long id){
        Produto produto = this.produtoRepository.getReferenceById(id);
        this.produtoRepository.delete(produto);
    }
}
