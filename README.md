# Lista de Livros

![GitHub](https://img.shields.io/github/license/AnaBilecki/book-list)

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/16986858-cb57700b-a5ad-4c62-aaf1-44469986a629?action=collection%2Ffork&collection-url=entityId%3D16986858-cb57700b-a5ad-4c62-aaf1-44469986a629%26entityType%3Dcollection%26workspaceId%3Def935334-e741-48cf-8704-98aec967d286)

Este projeto é um CRUD desenvolvido em linguagem Java e Spring Boot. Ele permite inserir, visualizar, atualizar e deletar informações de uma lista de livros. Além disso, é possível aplicar consultas para filtrar os livros com base nos atributos título e ISBN.

## Tabela de conteúdos

   * [Sobre](#lista-de-livros)
   * [Modelo conceitual](#modelo-conceitual)
   * [Tecnologias utilizadas](#tecnologias-utilizadas)
   * [Ferramentas utilizadas](#ferramentas-utilizadas)
   * [Dependências utilizadas](#dependências-utilizadas)
   * [Como executar o projeto](#como-executar-o-projeto)
     * [Pré-requisitos](#pré-requisitos)
     * [Execução](#execução)
   * [Endpoints](#endpoints)
   * [Autora](#autora)

## Modelo conceitual

<div align="center">
<img src="https://user-images.githubusercontent.com/84636509/155130676-a4b0b72a-ac17-4515-b455-b9648a79b8f3.PNG" width="500px" />
</div>

## Tecnologias utilizadas

As seguintes tecnologias foram utilizadas na construção do projeto:

   * Java
   * JPA/Hibernate
   * Maven
   * Spring Boot

## Ferramentas utilizadas

As seguintes ferramentas foram utilizadas na construção do projeto:

   * [JDK](https://www.oracle.com/java/technologies/downloads/) | Versão 11.0.11
   * [Postman](https://www.postman.com/downloads/) | Versão 8.11.1
   * [Spring Tool Suite](https://spring.io/tools) | Versão 4.11.0

## Dependências utilizadas

| Nome                                                                               |                                          Descrição                                          |
| -------------------------------------------------------------------------------------------- | :-----------------------------------------------------------------------------------------: |
| [h2](https://mvnrepository.com/artifact/com.h2database/h2)                                               |                   Banco de dados relacional em memória               |
| [lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok)                                               |                   Framework para geração de métodos getters e setters, construtores e entre outros                |
| [modelmapper](https://mvnrepository.com/artifact/org.modelmapper/modelmapper)                                               |                   Framework para mapeamento entre objetos               |
| [spring-boot-starter-data-jpa](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa)                                               |                   Framework para persistência de objetos Java                 |
| [spring-boot-starter-validation](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation)                                               |                   Framework para validação de dados                 |

## Como executar o projeto

### Pré-requisitos

Para que seja possível executar o projeto, é necessário que em sua máquina estejam instalados:

   * [Git](https://git-scm.com/)
   * JDK
   * Postman
   * Spring Tool Suite

### Execução

1. Abra um terminal do Git na pasta desejada e clone este repositório:
```bash
$ git clone https://github.com/AnaBilecki/book-list
```
2. Em seguida, abra o projeto no Spring Tool Suite e o execute.
3. O servidor iniciará na porta 8080. Após iniciado, realize as ações de CRUD pelo Postman.

## Endpoints

Os _endpoints_ deste projeto estão documentados abaixo:

| Método HTTP          |  Resource Path | Descrição                        |
| -------------------- | -------------- | :------------------------------: |
| GET                  |  /books        | Lista de livros |
| GET                  |  /categories        | Lista de categorias |
| GET                  |  /books/       | Busca de livro por ID |
| GET                  |  /categories/        | Busca de categoria por ID |
| POST                  |  /books/        | Inserção de um livro |
| POST                  |  /categories/        | Inserção de uma categoria |
| DELETE                  |  /books/        | Deleção de um livro |
| DELETE                  |  /categories/        | Deleção de uma categoria |
| PUT                  |  /books/        | Atualização de um livro |
| PUT                  |  /categories/        | Atualização de uma categoria |
| GET                  |  /books/search        | Lista de livros filtrados |

### Consultar todos os livros | GET /books

Nesse _endpoint_ é retornada a lista atual com todos os livros cadastrados com um HTTP 200.

### Consultar livro pelo ID | GET /books/{id}

Nesse _endpoint_ é retornado o livro que possui o ID passado como parâmetro com um HTTP 200. No caso do livro não ser localizado, é retornado um HTTP 404.

Exemplo de chamada:

```
http://localhost:8080/books/3
```

Resultado:

```json
{
    "id": 3,
    "title": "The Adventures of Sherlock Holmes",
    "author": "Sir Arthur Conan Doyle",
    "yearPublished": 2020,
    "publishingCompany": "CreateSpace Independent Publishing Platform",
    "edition": 1,
    "isbn": "978-1508475316",
    "shortDescription": "Mystery book",
    "numberOfPages": 164,
    "category": {
        "id": 2,
        "name": "Mystery"
    }
}
```

### Inserir livro | POST /books

Nesse _endpoint_ será inserido na base de dados um livro com os dados passados no _body_, conforme:

- **title**: título
- **author**: autor
- **yearPublished**: ano de publicação
- **edition**: edição
- **isbn**
- **shortDescription**: descrição curta
- **numberOfPages**: número de páginas
- Category:
    - **id**: id da categoria
    - **name**: nome da categoria

Durante a crição o único campo não obrigatório é _shortDescription_. Antes dos dados serem persistidos na base de dados, eles serão validados de acordo com o formato apresentado no diagrama de classes na Seção [Modelo conceitual](#modelo-conceitual). Caso estejam válidos, retornará o livro com um HTTP 201.

### Remover livro | DELETE /books/{id}

Nesse _endpoint_ é deletado o livro com o ID passado via _path param_. Caso o livro seja encontrado, o retorno será vazio e com um HTTP 204. Do contrário, ocorrerá um HTTP 404.

### Atualizar livro | PUT /books/{id}

Nesse _endpoint_ é atualizado o livro com o ID passado via _path param_ retornando um HTTP 200. Conforme recebidos no _body_ da requisição, os seguintes parâmetros serão atualizados:

- **title**: título
- **author**: autor
- **yearPublished**: ano de publicação
- **edition**: edição
- **isbn**
- **shortDescription**: descrição curta
- **numberOfPages**: número de páginas
- Category:
    - **id**: id da categoria
    - **name**: nome da categoria

Durante a atualização o único campo não obrigatório é _shortDescription_.

### Consultar todos as categorias | GET /categories

Nesse _endpoint_ é retornada a lista atual com todas as categorias cadastradas com um HTTP 200.

### Consultar categoria pelo ID | GET /categories/{id}

Nesse _endpoint_ é retornada a categoria que possui o ID passado como parâmetro com um HTTP 200. No caso da categoria não ser localizada, é retornado um HTTP 404.

Exemplo de chamada:

```
http://localhost:8080/categories/3
```

Resultado:

```json
{
    "id": 3,
    "name": "Fantasy"
}
```

### Inserir categoria | POST /categories

Nesse _endpoint_ será inserida na base de dados uma categoria com os dados passados no _body_, conforme:

  - **name**: nome da categoria

Durante a crição o campo _name_ é obrigatório. Antes dos dados serem persistidos na base de dados, eles serão validados de acordo com o formato apresentado no diagrama de classes na Seção [Modelo conceitual](#modelo-conceitual). Caso estejam válidos, retornará a categoria com um HTTP 201.

### Remover categoria | DELETE /categories/{id}

Nesse _endpoint_ é deletada a categoria com o ID passado via _path param_. Caso a categoria seja encontrada, o retorno será vazio e com um HTTP 204. Do contrário, ocorrerá um HTTP 404.

### Atualizar categoria | PUT /categories/{id}

Nesse _endpoint_ é atualizada a categoria com o ID passado via _path param_ retornando um HTTP 200. Conforme recebidos no _body_ da requisição, o seguinte parâmetro será atualizado:

- **name**: nome da categoria

Durante a atualização o campo _name_ é obrigatório.

### Filtrar livros | GET /books/search

Nesse _endpoint_ será retornada a lista atual dos livros filtrados de acordo com os parâmetros passados na URL:

| Parâmetro          |  Descrição do filtro                       |
| -------------------- | :------------------------------: |
| title                 | Pesquisa pelo título do livro  |
| isbn                |  Pesquisa pelo ISBN do livro |

Nenhum parâmetro é obrigatório na requisição.
Exemplo de pesquisa:

```
http://localhost:8080/books/search?title=Life%20of%20Pi
```

Resultado:

```json
[
    {
        "id": 1,
        "title": "Life of Pi",
        "author": "Yann Martel",
        "yearPublished": 2003,
        "publishingCompany": "Mariner Books",
        "edition": 3,
        "isbn": "978-0156027328",
        "shortDescription": "Adventure book",
        "numberOfPages": 326,
        "category": {
            "id": 1,
            "name": "Adventure"
        }
    }
]
```

## Autora

Ana Carolina Bilecki
