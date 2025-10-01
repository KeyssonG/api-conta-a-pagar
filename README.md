# API Conta a Pagar

Este projeto é uma API REST para gerenciamento de contas a pagar, desenvolvida em Java 21 com Spring Boot, Hibernate, H2 Database e Docker.

## Funcionalidades
- Cadastro, consulta e gerenciamento de contas a pagar
- Documentação automática via Swagger
- Banco de dados em memória (H2)
- Configuração de CORS para integração com front-end
- Migração de banco com Flyway

## Requisitos
- Java 21
- Maven
- Docker

## Como executar localmente

### 1. Build da imagem Docker
```bash
sudo docker build -t api-conta-apagar .
```

### 2. Subir o container
```bash
sudo docker run --name api-conta-apagar -p 8084:8084 api-conta-apagar
```

### 3. Acessar a API e ferramentas
- **Swagger:** [http://localhost:8084/swagger-ui/index.html](http://localhost:8084/swagger-ui/index.html)
- **H2 Console:** [http://localhost:8084/h2-console](http://localhost:8084/h2-console)
  - JDBC URL: `jdbc:h2:mem:contapagar`
  - Usuário: `sa`
  - Senha: *(em branco)*

## Configurações importantes

O arquivo `src/main/resources/application.properties` contém as principais configurações:
```properties
server.port=8084
spring.datasource.url=jdbc:h2:mem:contapagar;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.h2.console.settings.web-allow-others=true
```

## Observações
- Para acessar o H2 Console remotamente, a opção `spring.h2.console.settings.web-allow-others=true` está habilitada.
- O CORS está configurado para permitir integração com front-end externo.

## Estrutura do Projeto
```
├── Dockerfile
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   └── desafio/deliver/api_conta_pagar/
│       └── resources/
│           └── application.properties
```