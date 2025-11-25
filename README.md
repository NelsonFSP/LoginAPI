# LoginAPI

API simples para CRUD de usuários usando Java (Spring Boot) e MongoDB.

Este repositório contém uma aplicação Spring Boot que expõe endpoints HTTP para criar, buscar, listar e deletar usuários. Foi construída com Maven e usa o starter do Spring Data MongoDB.

Principais tecnologias
- Java (versão declarada em `pom.xml`: 25)
- Spring Boot (versão no `pom.xml`)
- MongoDB
- MapStruct (mapeamento)
- Lombok

Pré-requisitos
- JDK compatível com a versão declarada em `pom.xml` (propriedade `java.version`). O `pom.xml` atual define `java.version = 25`. Se você não tiver essa versão instalada, ajuste a propriedade no `pom.xml` para a sua versão de JDK (por exemplo 17 ou 21) antes de buildar.
- Maven (ou use o wrapper incluído)
- MongoDB rodando localmente (ou uma URI de conexão válida)

Configuração do MongoDB
A string de conexão default está em `src/main/resources/application.properties`:

spring.data.mongodb.uri=mongodb://localhost:27017/logando-API

Se você quiser usar outra instância do MongoDB, atualize o arquivo acima ou configure a variável de ambiente correspondente ao rodar a aplicação (por exemplo, passando `-Dspring.data.mongodb.uri="sua-uri"`).

Build e execução
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

Executando testes

```powershell
mvnw.cmd test
```

Endpoints disponíveis
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

Observações e notas úteis
- O DTO atual (`UserDTO`) contém o campo `password` e ele é retornado nas respostas. Em produção, remova ou oculte o campo de senha das respostas e armazene senhas de forma segura (hash + salt).
- O arquivo `pom.xml` define `java.version = 25`. Altere conforme sua JDK local, se necessário.

Nota sobre um pequeno problema no código
No `UserController` existe um método `buscarUsuarios` anotado com `@GetMapping(value = "/users")` que declara um parâmetro `@PathVariable String id` — esse parâmetro não é usado e causa confusão. A correção simples é remover o `@PathVariable String id` do método `buscarUsuarios`.

Correção sugerida (exemplo):

```java
@GetMapping(value = "/users")
public ResponseEntity<?> buscarUsuarios(){
    return ResponseEntity.ok(service.listarUsuarios());
}
```

Se quiser, eu posso aplicar essa correção no código.

Contribuição
- Abra uma issue ou envie um pull request com melhorias.
- Para desenvolvimento, rode o Spring Boot em modo dev (IDE ou `spring-boot:run`) e teste os endpoints com Postman / curl.

Licença
- Este projeto não possui licença especificada no repositório. Adicione uma licença se desejar permitir uso/redistribuição.
