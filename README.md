# springboot-learning-crud

---

# 📌 Cadastro de Usuários - Spring Boot

API REST simples para gerenciamento de usuários, desenvolvida com **Spring Boot**, utilizando **JPA/Hibernate** e banco em memória **H2**.

---

## 🚀 Tecnologias utilizadas

* Java 21
* Spring Boot
* Spring Web MVC
* Spring Data JPA
* H2 Database
* Lombok
* Maven

---

## 📂 Estrutura do Projeto

```
src/main/java/com/yamamoto/cadastro_usuario
│
├── business          # Regras de negócio (Service)
├── controller        # Camada de entrada (REST API)
├── infrastructure
│   ├── entitys       # Entidades JPA
│   └── repository    # Repositórios (acesso ao banco)
│
└── CadastroUsuarioApplication.java
```

---

## ⚙️ Configuração do Banco (H2)

O projeto utiliza banco em memória, ideal para testes.

### 🔗 Acessar console H2:

```
http://localhost:8080/h2-console
```

### 🧾 Configurações:

```
JDBC URL: jdbc:h2:mem:usuario
User: sa
Password: (vazio)
```

---

## 📌 Endpoints da API

### ➕ Criar usuário

```
POST /usuario
```

**Body:**

```json
{
  "email": "teste@email.com",
  "nome": "Arthur"
}
```

---

### 🔍 Buscar usuário por email

```
GET /usuario?email=teste@email.com
```

---

### ❌ Deletar usuário por email

```
DELETE /usuario?email=teste@email.com
```

---

### 🔄 Atualizar usuário por ID

```
PUT /usuario?id=1
```

**Body (parcial ou completo):**

```json
{
  "email": "novo@email.com",
  "nome": "Novo Nome"
}
```

✔ Atualização inteligente:

* Só altera campos enviados
* Mantém os demais dados existentes

---

## 🧠 Regras de Negócio

* Email é único no sistema
* Busca por email retorna erro caso não exista
* Atualização preserva dados não informados
* Exclusão feita diretamente por email

---

## 🛠️ Como rodar o projeto

```bash
# Clonar repositório
git clone https://github.com/arthuryamamoto2701/springboot-learning-crud.git

# Entrar na pasta
cd cadastro-usuario

# Rodar aplicação
./mvnw spring-boot:run
```

Ou pela sua IDE (IntelliJ / VS Code / Eclipse).

---

## 📌 Observações

* Banco H2 é volátil (dados são perdidos ao reiniciar)
* Projeto focado em aprendizado de:

  * Arquitetura em camadas
  * Spring Data JPA
  * APIs REST

---

## 📈 Melhorias futuras

* [ ] Tratamento global de exceções
* [ ] DTOs para desacoplamento
* [ ] Validação com Bean Validation (`@Valid`)
* [ ] Paginação e listagem de usuários
* [ ] Autenticação com JWT
* [ ] Testes automatizados

---

## 👨‍💻 Autor

Desenvolvido por **Arthur Yamamoto**

---


