# AS_POO

🛒 Spring Boot API – Categorias e Produtos

Este projeto é uma API REST desenvolvida em Spring Boot utilizando Spring Data JPA, organizada em camadas (Controller, Service, Repository).
A aplicação gerencia entidades de Categoria e Produto, contendo relacionamento One-To-Many entre elas.

🚀 Tecnologias Utilizadas

* Java 17+

* Spring Boot

* Spring Web

* Spring Data JPA

* Hibernate

* Banco de dados (H2 / MySQL / PostgreSQL — conforme sua configuração)

* Maven

🎯 Para que serve esse projeto?

Este projeto tem como objetivo fornecer uma API REST simples, modular e escalável para gerenciar Categorias e Produtos, servindo como base para estudos ou como ponto de partida para aplicações maiores.

Ele é útil para:

📘 Aprender ou ensinar Spring Boot com uma estrutura limpa baseada em boas práticas.

🗄 Demonstrar uso de Spring Data JPA, com operações CRUD e paginação.

🔄 Mostrar como funciona um relacionamento One-To-Many entre entidades (Categoria ↔ Produtos).

🧱 Construir APIs RESTful organizadas com camadas Controller → Service → Repository.

🧪 Servir como base para aplicações comerciais, como sistemas de:

E-commerce

Catálogo de produtos

Estoque

Inventário

É um projeto enxuto, fácil de entender e ideal para estudos, provas práticas, testes técnicos e aprendizado de arquitetura com Spring.

📂 Estrutura do Projeto
src/main/java/br/com/ulbra/demo/
│
├── controllers/
│   ├── CategoriaController.java
│   └── ProdutoController.java
│
├── dtos/
│   ├── CategoriaDTO.java
│   └── ProdutoDTO.java
│
├── entities/
│   ├── Categoria.java
│   └── Produto.java
│
├── repositories/
│   ├── CategoriaRepository.java
│   └── ProdutoRepository.java
│
└── services/
    ├── CategoriaService.java
    └── ProdutoService.java

🧩 Relacionamentos
Categoria

id

name

produtos → List<Produto>

Relacionamento: 1 Categoria -> N Produtos

Produto

id

name

preco

categoria → Categoria

Relacionamento: N Produtos -> 1 Categoria

📡 Endpoints
📁 Categorias
Método	Endpoint	Descrição
GET	/categorias	Lista paginada de categorias
GET	/categorias/{id}	Busca categoria por ID
POST	/categorias	Cria uma nova categoria
PUT	/categorias/{id}	Atualiza categoria existente
DELETE	/categorias/{id}	Remove categoria
Exemplo de JSON para criação:
{
  "name": "Informática"
}

📦 Produtos
Método	Endpoint	Descrição
GET	/produtos	Lista paginada de produtos
GET	/produtos/{id}	Busca produto por ID
POST	/produtos	Cria um novo produto
PUT	/produtos/{id}	Atualiza produto existente
DELETE	/produtos/{id}	Remove produto
Exemplo de JSON para criação:
{
  "name": "Notebook",
  "preco": 3500.00,
  "categoria": {
    "id": 1
  }
}

🛠 Como Rodar o Projeto
1. Clone o repositório
git clone https://github.com/seu-repo.git
cd seu-repo

2. Compile o projeto
mvn clean install

3. Execute a aplicação
mvn spring-boot:run

4. Acesse a aplicação
http://localhost:8080

📌 Observações Importantes

ProdutoRepository contém um método inválido:

Long id(Long id);


Deve ser removido, pois causa erro.

Os DTOs estão criados mas não estão sendo usados nos controllers.
Para boas práticas, recomenda-se implementar um mapper (ModelMapper ou MapStruct).

Em POST de Categoria/Produto, a URI é construída usando categoria.getId() e produto.getId(), porém o ID ainda não existe antes do save.
A ordem correta seria:

Produto saved = produtoService.createProduto(produto);
URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(saved.getId())
        .toUri();

return ResponseEntity.created(uri).body(saved);

📄 Licença

Este projeto está sob a licença MIT — sinta-se livre para usar e modificar!
