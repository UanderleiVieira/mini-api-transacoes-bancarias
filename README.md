# 🏦 Mini-API de Transações Bancárias

Uma API RESTful desenvolvida com Spring Boot para simulação de operações bancárias (Depósitos, Saques e Transferências), focada no cumprimento das propriedades ACID e tratamento transacional de dados.

---

## 📌 Regras de Negócio e Funcionalidades

- [x] **Gestão de Clientes:** Cadastro e vinculação de clientes a contas.
- [x] **Gestão de Contas:** Abertura e alteração de status (ATIVA/INATIVA).
- [ ] **Operações Financeiras:**
    - Depósitos e Saques com validação de saldo.
    - Transferências entre contas com garantia de Rollback em caso de erro (`@Transactional`).
- [ ] **Tratamento de Exceções:** Retorno de erros padronizados (RFC 7807) para saldos insuficientes ou contas inativas.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 17+
- **Framework:** Spring Boot 3+
- **Persistência de Dados:** Spring Data JPA / Hibernate
- **Banco de Dados:** PostgreSQL
- **Utilitários:** Lombok
- **Gerenciador de Dependências:** Maven

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
- Java 17 ou superior instalado
- PostgreSQL rodando localmente
- Maven

### Passos
1. Clone o repositório:
   ```bash
   git clone [https://github.com/seu-usuario/mini-api-transacoes-bancarias.git](https://github.com/seu-usuario/mini-api-transacoes-bancarias.git)