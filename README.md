# 🚀 API REST - Sistema de Gestão de Vendas e Afiliados

[![Java](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15%2B-blue?logo=postgresql)](https://www.postgresql.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

API RESTful completa desenvolvida para gerenciamento de produtos, vendas e comissões de afiliados. O projeto foi construído seguindo arquitetura em camadas, boas práticas de Domain-Driven Design (DDD) simplificado, tratamento global de exceções e persistência de dados.

---

## 📌 Funcionalidades

- [x] **Gestão de Produtos:** Cadastro, atualização, listagem com paginação e exclusão de produtos.
- [x] **Gestão de Afiliados:** Registro e controle de perfil de afiliados.
- [x] **Processamento de Vendas:** Registro de transações com cálculo automático de comissão.
- [x] **Consultas Personalizadas:** Filtros avançados com *Derived Queries* e JPQL para relatórios de desempenho.
- [x] **Tratamento de Exceções:** Respostas padronizadas no formato RFC 7807 (`CustomExceptionHandler`).
- [x] **Validação de Dados:** Garantia da integridade das requisições com *Bean Validation*.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 17
* **Framework:** Spring Boot 3
* **Acesso a Dados:** Spring Data JPA / Hibernate
* **Banco de Dados:** PostgreSQL (Produção/Dev) e H2 Database (Testes)
* **Documentação:** OpenAPI 3 / Swagger UI
* **Mapeamento:** MapStruct / ModelMapper
* **Automação de Código:** Lombok
* **Gerenciador de Dependências:** Maven

---

## 🏗️ Arquitetura do Projeto

```text
src/
├── main/
│   ├── java/com/dev/projetovendas/
│   │   ├── config/          # Configurações da aplicação (Swagger, CORS)
│   │   ├── controller/      # Camada Web (Endpoints REST)
│   │   ├── dto/             # Data Transfer Objects (Request/Response)
│   │   ├── exception/       # Handler global e exceções personalizadas
│   │   ├── model/           # Entidades JPA (ORM)
│   │   ├── repository/      # Interfaces Spring Data JPA
│   │   └── service/         # Regras de negócio e serviços
│   └── resources/
│       ├── application.properties
│       └── db/migration/    # Scripts SQL para migração