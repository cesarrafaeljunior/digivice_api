<h1 align="center"> Digivice Api </h1>

<hr>

<p> A Digivice API é uma ferramenta que permite acessar informações sobre Digimons. Ela se integra a uma fonte externa de dados sobre essas criaturas digitais e oferece a flexibilidade de filtrar os resultados com base em critérios como nome e nível. Isso torna a consulta de informações sobre Digimons mais fácil e personalizável para atender às suas necessidades específicas.</p>

#### Tecnologias utilizadas:
 - Java 17.0.6
 - Spring Boot 3.1.5
 - Maven

### Tópicos

- [Api Deploy](#api-deploy)
- [Rodando localmente](#rodando-a-api-localmente) 
- [Doc da API](#documentacao-da-api)

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

### Requests

- [Buscar todos os digimons](#buscar-todos-os-digimons)
- [Buscar Digimon pelo nome](#buscar-digimon-pelo-nome)
- [Buscar digimon com nome não existente](#buscar-digimon-com-nome-nao-existente)
- [Buscar digimon por level](#buscar-digimon-por-level)
- [Leveis disponíveis](#leveis-disponiveis)
- [Buscar digimon com level não existente](#buscar-digimon-com-level-nao-existente)
- [Buscar Digimon pelo level e nome](#buscar-digimon-pelo-level-e-nome)

### Digimons

#### Buscar todos os Digimons

`GET /digimons - FORMATO DE RESPOSTA- Status Code - 200`
<P>Exemplo de resposta</p>

```json
[
   {
     "name": "Koromon",
     "img": "https://digimon.shadowsmith.com/img/koromon.jpg",
     "level": "In Training"
   },
   {
     "name": "Tsunomon",
     "img": "https://digimon.shadowsmith.com/img/tsunomon.jpg",
     "level": "In Training"
   },
   {
     "name": "Yokomon",
     "img": "https://digimon.shadowsmith.com/img/yokomon.jpg",
     "level": "In Training"
   },
]
```

<hr>

#### Buscar Digimon pelo nome

`GET /digimons?name=Koromon - FORMATO DE RESPOSTA- Status Code - 200`
<P>Exemplo de resposta</p>

```json
[
   {
     "name": "Koromon",
     "img": "https://digimon.shadowsmith.com/img/koromon.jpg",
     "level": "In Training"
   }
]
```

<hr>

#### Buscar Digimon com nome não existente

`GET /digimons?name=pikachu - FORMATO DE RESPOSTA- Status Code - 200`
<P>Exemplo de resposta</p>

```json
{
   "timestamp": "2023-10-30T03:10:02.850076Z",
   "status": "BAD_REQUEST",
   "error": "Pikachu is not a Digimon in our database.",
   "path": "/digimons"
}
```

<hr>

#### Buscar digimon por level
##### Leveis disponíveis
- In Training
- Rookie
- Champion
- Ultimate
- Fresh
- Mega
- Armor
  
`GET /digimons?level=armor - FORMATO DE RESPOSTA- Status Code - 200`
<P>Exemplo de resposta</p>

```json
[
   {
     "name": "Flamedramon",
     "img": "https://digimon.shadowsmith.com/img/flamedramon.jpg",
     "level": "Armor"
   },
   {
     "name": "Raidramon",
     "img": "https://digimon.shadowsmith.com/img/raidramon.jpg",
     "level": "Armor"
   },
   {
     "name": "Magnamon",
     "img": "https://digimon.shadowsmith.com/img/magnamon.jpg",
     "level": "Armor"
   },
   {
     "name": "Sethmon",
     "img": "https://digimon.shadowsmith.com/img/sethmon.jpg",
     "level": "Armor"
   },
]
```

<hr>

#### Buscar Digimon com level não existente

`GET /digimons?level=big - FORMATO DE RESPOSTA- Status Code - 200`
<P>Exemplo de resposta</p>

```json
{
   "timestamp": "2023-10-30T03:14:34.160189300Z",
   "status": "BAD_REQUEST",
   "error": "Big is not a level in our database.",
   "path": "/digimons"
}
```

#### Buscar Digimon pelo level e nome

`GET /digimons?level=rookie&name=agumon - FORMATO DE RESPOSTA- Status Code - 200`
<P>Exemplo de resposta</p>

```json
[
   {
     "name": "Agumon",
     "img": "https://digimon.shadowsmith.com/img/agumon.jpg",
     "level": "Rookie"
   }
]
```
<hr>
