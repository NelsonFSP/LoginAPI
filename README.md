# LoginAPI

API simples para CRUD de usuários construída em Java com Spring Boot.

Sumário
- [Sobre](#sobre)
- [Tecnologias](#tecnologias)
- [Pre-requisitos](#pre-requisitos)
- [Configuracao](#configuracao)
- [Build e execucao](#build-e-execucao)
- [Executando testes](#executando-testes)
- [Endpoints](#endpoints)
- [Observacoes de seguranca](#observacoes-de-seguranca)
- [Contribuicao](#contribuicao)
- [Licenca](#licenca)

## Sobre
Este repositório contém uma aplicação Spring Boot que expõe endpoints HTTP para criar, buscar, listar e deletar usuários. A aplicação foi construída com Maven e usa mapeamentos via MapStruct e utilitários do Lombok.

## Tecnologias
[![Java](https://img.shields.io/badge/Java-25-blue?logo=java)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-used-6DB33F?logo=spring)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-used-CC0000?logo=apache-maven)](https://maven.apache.org/)
[![DynamoDB](https://img.shields.io/badge/DynamoDb-used-blue)](https://aws.amazon.com/pt/dynamodb/)
[![MapStruct](https://img.shields.io/badge/MapStruct-used-4F5B93?logo=mapstruct)](https://mapstruct.org/)
[![Lombok](https://img.shields.io/badge/Lombok-used-C51A4A?logo=project-lombok)](https://projectlombok.org/)
[![JUnit](https://img.shields.io/badge/JUnit-used-25A162?logo=junit)](https://junit.org/)
[![Docker Compose](https://img.shields.io/badge/Docker%20Compose-used-2496ED?logo=docker)](https://docs.docker.com/compose/)

## Pre-requisitos
- JDK compatível com a versão declarada em `pom.xml` (propriedade `java.version`). O `pom.xml` atual define `java.version = 25`. Se não tiver essa versão, ajuste a propriedade no `pom.xml` para sua versão instalada (por exemplo 17 ou 21).
- Maven (ou use o wrapper incluído `mvnw` / `mvnw.cmd`)
- DynamoDb rodando localmente ou uma URI de conexão válida

## Configuracao
A string de conexão default está em `src/main/resources/application.properties`:

```
spring.data.mongodb.uri=mongodb://localhost:27017/logando-API
```

Altere essa URI caso queira apontar para outro banco.

## Build e execucao
No Windows (usando o wrapper incluído):

```powershell
mvnw.cmd clean package
mvnw.cmd spring-boot:run
```

Ou execute o JAR gerado:

```powershell
mvnw.cmd clean package
java -jar target\LoginAPI-0.0.1-SNAPSHOT.jar
```

No Linux / macOS:

```bash
./mvnw clean package
./mvnw spring-boot:run
# ou
java -jar target/LoginAPI-0.0.1-SNAPSHOT.jar
```

## Executando testes

```powershell
mvnw.cmd test
```

## Endpoints
Base URL: http://localhost:8080 (porta padrão do Spring Boot)

1) Criar novo usuário
- Método: POST
- URL: /user
- Corpo (JSON):

```json
{
  "name": "Fulano",
  "login": "fulano",
  "password": "senha123"
}
```
- Resposta: objeto de usuário salvo (inclui `id` gerado)

2) Buscar usuário por id
- Método: GET
- URL: /{id}
- Exemplo: GET /646f6c9e... 
- Resposta: `200 OK` com o objeto `UserDTO` (campos: `id`, `name`, `login`, `password`)

3) Listar todos os usuários
- Método: GET
- URL: /users
- Resposta: lista de usuários

4) Deletar usuário
- Método: DELETE
- URL: /delete/{id}
- Resposta: `202 Accepted` se a operação for aceita

## Observacoes de seguranca
- O DTO atual (`UserDTO`) contém o campo `password` e ele é retornado nas respostas. Em produção, remova ou oculte o campo de senha das respostas e armazene senhas de forma segura (hash + salt).

## Notas do projeto
- O arquivo `pom.xml` define `java.version = 25`. Altere conforme sua JDK local, se necessário.
- No `UserController` existe um método `buscarUsuarios` anotado com `@GetMapping(value = "/users")` que declara um parâmetro `@PathVariable String id` — esse parâmetro não é usado. A correção simples é remover o `@PathVariable String id` do método. Posso aplicar essa correção no código se desejar.

## Contribuicao
- Abra uma issue ou envie um pull request com melhorias.
- Para desenvolvimento, rode o Spring Boot em modo dev (IDE ou `spring-boot:run`) e teste os endpoints com Postman / curl.

## Licenca
- Este projeto não possui licença especificada no repositório. Adicione uma licença caso queira permitir uso/redistribuição.
