package br.com.ulbra.demo.dtos.request;

public class ProdutosRequest {
    private Long categoriaId;
    private String name;
    private double preco;

    public ProdutosRequest(){}
    public ProdutosRequest(Long categoriaId, String name, double preco) {
        this.categoriaId = categoriaId;
        this.name = name;
        this.preco = preco;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
