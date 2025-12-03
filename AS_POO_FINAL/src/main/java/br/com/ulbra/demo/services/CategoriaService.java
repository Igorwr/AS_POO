package br.com.ulbra.demo.services;

import br.com.ulbra.demo.entities.Categoria;
import br.com.ulbra.demo.repositories.CategoriaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria getCategoria(Long id){
        return categoriaRepository.findById(id).orElseThrow();
    }

    public Page<Categoria> getCategorias(Pageable pageable){
        return this.categoriaRepository.findAll(pageable);
    }

    public Categoria createCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public void updateCategoria(Long id, Categoria categoriaRequest){
        Categoria categoria = this.categoriaRepository.getReferenceById(id);
        categoria.setName(categoriaRequest.getName());

        this.categoriaRepository.save(categoria);
    }

    public void deleteCategoria(Long id){
        Categoria categoria = this.categoriaRepository.getReferenceById(id);
        this.categoriaRepository.delete(categoria);
    }

}