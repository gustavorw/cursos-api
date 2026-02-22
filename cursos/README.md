# cursos-api

API simples para gerenciamento de cursos escrita em Java + Spring Boot.

Este repositório contém uma aplicação Spring Boot com operações básicas para criar, listar, atualizar, ativar e remover cursos.

## Tecnologias

- Java (versão conforme seu ambiente)
- Spring Boot
- Maven (usando o wrapper `mvnw`)
- Docker / Docker Compose (opcional)

## Estrutura do projeto (resumo)

- `src/main/java` - código fonte da aplicação
  - `com.grw.cursos` - pacote principal
  - `modules/course` - módulo com controllers, usecases, entidades e repositório
- `src/main/resources/application.properties` - configurações da aplicação
- `pom.xml` - configuração do Maven
- `docker-compose.yml` - arquivo para subir dependências/serviços via Docker (se aplicável)

## Endpoints principais

Base path: `/courses`

- POST `/courses/` - Cria um curso
  - Body: JSON com a entidade `CourseEntity` (ver DTO/Entity em `modules/course/entities`)
  - Exemplo curl:

    ```bash
    curl -X POST http://localhost:8080/courses/ \
      -H "Content-Type: application/json" \
      -d '{"title":"Meu Curso","description":"Descrição do curso"}'
    ```

- GET `/courses/` - Retorna a lista de cursos
  - Exemplo:

    ```bash
    curl http://localhost:8080/courses/
    ```

- PUT `/courses/{id}` - Atualiza um curso
  - Body: `CourseUpdateDTO` (ver `modules/course/dtos/CourseUpdateDTO.java`)
  - Exemplo:

    ```bash
    curl -X PUT http://localhost:8080/courses/<uuid> \
      -H "Content-Type: application/json" \
      -d '{"title":"Novo título"}'
    ```

- PATCH `/courses/{id}/activate` - Ativa um curso
  - Exemplo:

    ```bash
    curl -X PATCH http://localhost:8080/courses/<uuid>/activate
    ```

- DELETE `/courses/{id}` - Remove um curso
  - Exemplo:

    ```bash
    curl -X DELETE http://localhost:8080/courses/<uuid>
    ```

> Observação: os exemplos assumem que o servidor está rodando em `localhost:8080`.

## Como rodar localmente

Usando o wrapper do Maven (recomendado):

```bash
# rodar a aplicação
./mvnw spring-boot:run

# buildar o JAR
./mvnw clean package

# executar os testes
./mvnw test
```

Se preferir usar o Maven instalado globalmente:

```bash
mvn spring-boot:run
mvn clean package
mvn test
```

Para executar o JAR gerado:

```bash
java -jar target/*.jar
```

## Rodando com Docker

Se houver um `Dockerfile`/`docker-compose.yml` presente:

```bash
# subir com docker-compose
docker-compose up --build
```

## Configurações

As configurações ficam em `src/main/resources/application.properties`. Altere conforme necessário para banco de dados, porta, etc.

## Testes

Os testes estão em `src/test/java`. Rode-os com `./mvnw test`.

## Contribuição

1. Fork do repositório
2. Crie uma branch feature/bugfix
3. Abra um pull request com uma descrição clara das mudanças

## Licença

Adicione aqui a licença do projeto (ex: MIT) ou remova esta seção se não for aplicável.

---

Se quiser, eu posso:
- adicionar exemplos de payloads mais precisos com base nas entidades do projeto;
- gerar um `README` mais detalhado com instruções de deploy (Heroku, Azure, etc.);
- criar um script de inicialização ou `Makefile` simples.
