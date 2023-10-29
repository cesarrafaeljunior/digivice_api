<h1 align="center"> Digivice Api </h1>

<hr>

<p> A Digivice API é uma ferramenta que permite acessar informações sobre Digimons. Ela se integra a uma fonte externa de dados sobre essas criaturas digitais e oferece a flexibilidade de filtrar os resultados com base em critérios como nome e nível. Isso torna a consulta de informações sobre Digimons mais fácil e personalizável para atender às suas necessidades específicas.</p>

### Tópicos

- [Api Deploy](#api-deploy)
- [Rodando localmente](#rodando-a-api-localmente) 
- [Doc da API](#doc-da-api)

<hr>

## Api deploy

- Você pode utilizar o seguinte link para testar a api: <a href="#">Link da api</a>

<hr>

# Rodando a api localmente
- [Por linha de comando](#por-linha-de-comando)
- [Utilizando o docker](#utilizando-o-docker)


## Por linha de comando

- Requisitos: É preciso ter o Maven e o JDK na versão 17 ou maior, instalados e configurados no sistema. 

### Clonando o repositório
  - Faça o clone do seguinte repositório:
    ``` bash
    
      git@github.com:cesarrafaeljunior/digivice_api.git
    
    ```
    <hr>
  - Abra a pasta do diretório utilizando o terminal/IDE, estando na raiz do projeto rode o comando para compilar o projeto:
    ``` bash
    
      mvn spring-boot:run
    
    ```
    <hr>
  - A seguinte mensagem significa que a api está pronto para ser utilizada:
    ``` bash
    
      2023-10-29T15:30:29.066-03:00  INFO 13788 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet : Completed initialization in 1 ms
    
    ```
    <hr>
  - Utilize o <a href="https://insomnia.rest/">Imsonia</a> ou qualquer outro software de chamadas HTTP para testar as rotas da API.
  - [Documentação da api](#documentacao-da-api)


## Utilizando o docker
- Requisitos: É preciso ter o Docker e o Maven instaladso e configurados no sistema. 

### Clonando o repositório
  - Faça o clone do seguinte repositório:
    ``` bash
    
      git@github.com:cesarrafaeljunior/digivice_api.git
    
    ```
    <hr>
  - Abra a pasta do diretório utilizando o terminal/IDE, estando na raiz do projeto rode o comando para compila o projeto:
    ``` bash
    
      mvn clean package
    
    ```
    <hr>
  - Após a compilação, rode o seginte comando para buildar a imagem do projeto a partir das configurações do aquivo Dockerfile:
    ``` bash
    
       docker build -t myapp .
    
    ```
    <hr>
  - Suba um contâiner para rodar a imagem da aplicação utilizando o seguinte comando:
    ``` bash
    
      docker run -p 8080:8080 myapp
    
    ```
    <hr>
  - Utilize o <a href="https://insomnia.rest/">Imsonia</a> ou qualquer outro software de chamadas HTTP para testar as rotas da API.
  - [Documentação da api](#documentacao-da-api)


<hr>

# Documentação da api

## UrlsBase:
  - Deploy:
  - Local: http://localhost:8080/digimons

### Usuários

#### Criação de usuário

`POST /user - FORMATO DE REQUISIÇÃO`

<p>Exemplo de requisição</p>

```json

{
	"name": "teste",
	"email":"teste@gmail.com",
	"password": "123456789",
}
```

`POST /user - FORMATO DE RESPOSTA- Status Code - 201`
<P>Exemplo de resposta</p>

```json
{
	"name": "teste",
	"email":"teste@gmail.com",
	"id": 1,
	"createdAt": "2023-03-24T16:22:47.649Z"
}
```

<hr>

#### Buscar todos os usuários cadastrados

`GET /user - FORMATO DE RESPOSTA- Status Code - 200`
<P>Exemplo de resposta</p>

```json
[{
	"name": "teste",
	"email":"teste@gmail.com",
	"id": 1,
	"createdAt": "2023-03-24T16:22:47.649Z"
}]
```

<hr>

#### Login de usuário

`POST /login - FORMATO DE REQUISIÇÃO`

<p>Exemplo de requisição</p>

```json

{
	"email": "teste",
	"password": "12345678"
}
```

`POST /login - FORMATO DE RESPOSTA- Status Code - 200`
<P>Exemplo de resposta</p>

```json
{
	"token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImNlc2FyIiwiaWF0IjoxNjc5OTMxNjU2LCJleHAiOjE2ODAwMTgwNTYsInN1YiI6ImE5ZTVkNzdlLTZmYjAtNDMwYS1iZDM0LTlmYjJlOTM5NGJkNSJ9.Wc4YnRRrmoyoKVWCRxC6C58E2qRi_DCqJOPDnf53BZE"
}
```

<hr>

## Rotas que precisam de autenticação:


### User
#### Buscar usuário logado
`GET /user - FORMATO DE RESPOSTA- Status Code - 200`
<P>Exemplo de resposta</p>

```json
{
	"name": "teste",
	"email":"teste@gmail.com",
	"id": 1,
	"createdAt": "2023-03-24T16:22:47.649Z"
}
```

<hr>


### Produtos

#### Cadastrar novo produto:

`POST /product - FORMATO DE REQUISIÇÃO`

<p>Exemplo de requisição</p>

```json

{
    "name": "Big-Burguer",
    "description": "O melhor lanche da casa!",
    "price": 22,
    "stock": 23,
    "category":{
        "name": "Lanches"
    }
}
```

`POST /product - FORMATO DE RESPOSTA- Status Code - 201`
<P>Exemplo de resposta</p>

```json
{
	"name": "Big-Burguer",
	"description": "O melhor lanche da casa!",
	"price": 22,
	"stock": 23,
	"category": {
		"id": 1,
		"name": "lanches"
	},
	"id": 1,
	"createdAt": "2023-10-02T23:49:53.319Z",
	"updatedAt": "2023-10-02T23:49:53.319Z"
}
```

<hr>

### Buscar todos os produtos:

`GET /product - FORMATO DE RESPOSTA- Status Code - 200`
<P>Exemplo de resposta</p>

```json
[{
	"name": "Big-Burguer",
	"description": "O melhor lanche da casa!",
	"price": 22,
	"stock": 23,
	"category": {
		"id": 1,
		"name": "lanches"
	},
	"id": 1,
	"createdAt": "2023-10-02T23:49:53.319Z",
	"updatedAt": "2023-10-02T23:49:53.319Z"
}]
```

<hr>

### Buscar um produto pelo id:

`GET /product/1 - FORMATO DE RESPOSTA- Status Code - 200`
<P>Exemplo de resposta</p>

```json
[{
	"name": "Big-Burguer",
	"description": "O melhor lanche da casa!",
	"price": 22,
	"stock": 23,
	"category": {
		"id": 1,
		"name": "lanches"
	},
	"id": 1,
	"createdAt": "2023-10-02T23:49:53.319Z",
	"updatedAt": "2023-10-02T23:49:53.319Z"
}]
```
<hr>

### Editar informações de um produto:

`PATCH /product/id - FORMATO DE REQUISIÇÃO`
<P>Exemplo de requisição</p>

```json
{
	"name":"Big-Burguer editado",
	"category": {
		"name": "lanches"
	}
}
```

`PATCH /product/id - FORMATO DE RESPOSTA- Status Code - 200`
<P>Exemplo de resposta</p>

```json
{
	"name": "Big-Burguer editado",
	"description": "Um hamburguersao muito dahora!",
	"price": 22,
	"stock": 23,
	"category": {
		"id": 9,
		"name": "lanches"
	},
	"id": 18,
	"createdAt": "2023-09-30T16:28:50.900Z",
	"updatedAt": "2023-09-30T16:29:15.124Z"
}
```

<hr>

### Deletar um produto:

`DELETE /product/id - FORMATO DE RESPOSTA- Status Code - 204`
```json
no body
```
<hr>
