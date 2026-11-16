# Gestão de Usuários

Sistema full stack para gerenciamento de usuários, desenvolvido com **Angular** no frontend e **Java + Spring Boot** no backend.

O projeto permite realizar operações de cadastro, consulta, atualização e exclusão de usuários, além de gerenciar perfis de acesso e o status de cada cadastro.

## Tecnologias utilizadas

### Frontend
- Angular
- TypeScript
- HTML5
- CSS3

### Backend
- Java
- Spring Boot
- Spring Data JPA
- MapStruct
- Maven
- API REST

### Ferramentas
- Git e GitHub
- Docker
- Postman / Apidog

## Funcionalidades

- Cadastro de usuários.
- Listagem de usuários.
- Atualização dos dados cadastrados.
- Exclusão de usuários.
- Gerenciamento de perfis de acesso (`USER` e `ADMIN`).
- Controle do status do usuário (ativo/inativo).
- Validação de dados.
- Integração entre frontend e backend por meio de API REST.

## Estrutura do projeto

```text
gestao-de-usuarios/
│
├── back-end/
│   ├── src/
│   ├── postman/
│   ├── pom.xml
│   └── docker-compose.yml
│
├── front-end/
│   ├── src/
│   ├── public/
│   ├── package.json
│   └── angular.json
│
└── README.md
```

## Como executar o projeto

### Pré-requisitos

- Java JDK
- Node.js e npm
- Maven (ou utilizar o Maven Wrapper disponível no projeto)
- Banco de dados configurado conforme as propriedades do backend

### 1. Clonar o repositório

```bash
git clone https://github.com/kellyxwz/gestao-de-usuarios.git
```

### 2. Executar o backend

Entre na pasta:

```bash
cd gestao-de-usuarios/back-end
```

Execute a aplicação:

```bash
./mvnw spring-boot:run
