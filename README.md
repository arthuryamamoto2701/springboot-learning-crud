````md
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
* Bean Validation

---

## 📂 Estrutura do Projeto

```bash
src/main/java/com/yamamoto/cadastro_usuario
│
├── business              # Regras de negócio (Service)
├── controller            # Camada de entrada (REST API)
├── dto                   # DTOs e mappers (entrada e saída da API)
│   └── usuario
│       ├── UsuarioRequest.java
│       ├── UsuarioResponse.java
│       └── UsuarioMapper.java
├── infrastructure
│   ├── entitys           # Entidades JPA
│   ├── repository        # Repositórios (acesso ao banco)
│   └── exception         # Tratamento global de exceções
│       └── GlobalExceptionHandler.java
│
└── CadastroUsuarioApplication.java
```

---

## ⚙️ Configuração do Banco (H2)

O projeto utiliza banco em memória, ideal para testes.

### 🔗 Acessar console H2

```bash
http://localhost:8080/h2-console
```

### 🧾 Configurações

```bash
JDBC URL: jdbc:h2:mem:usuario
User: sa
Password: (vazio)
```

---

## 📌 Endpoints da API

### ➕ Criar usuário

```http
POST /usuario
```

### Body

```json
{
  "email": "teste@email.com",
  "nome": "Arthur"
}
```

### Retorno

```json
{
  "id": 1,
  "email": "teste@email.com",
  "nome": "Arthur"
}
```

---

### 🔍 Buscar usuário por email

```http
GET /usuario?email=teste@email.com
```

### Retorno

```json
{
  "id": 1,
  "email": "teste@email.com",
  "nome": "Arthur"
}
```

---

### ❌ Deletar usuário por email

```http
DELETE /usuario?email=teste@email.com
```

---

### 🔄 Atualizar usuário por ID

```http
PUT /usuario?id=1
```

### Body (parcial ou completo)

```json
{
  "email": "novo@email.com",
  "nome": "Novo Nome"
}
```

### Retorno

```json
{
  "id": 1,
  "email": "novo@email.com",
  "nome": "Novo Nome"
}
```

✔ Atualização inteligente:

* Só altera campos enviados
* Mantém os demais dados existentes

---

## ✅ Validações implementadas

A API utiliza Bean Validation para validar automaticamente os dados recebidos.

### Regras atuais

* Nome obrigatório
* Nome com no mínimo 3 caracteres
* Email obrigatório
* Email deve possuir formato válido

### Exemplo de erro de validação

```json
{
  "nome": "Nome é obrigatório",
  "email": "Email inválido"
}
```

---

## 🧠 Regras de Negócio

* Email é único no sistema
* Busca por email retorna erro caso não exista
* Atualização preserva dados não informados
* Exclusão feita diretamente por email

---

## 📌 Observações

* Banco H2 é volátil (dados são perdidos ao reiniciar)
* A API utiliza DTOs para separar entrada e saída de dados, evitando expor diretamente as entidades do banco
* O projeto possui tratamento global de exceções utilizando `@RestControllerAdvice`
* Projeto focado em aprendizado de:
  * Arquitetura em camadas
  * Spring Data JPA
  * APIs REST
  * Bean Validation

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

## 📈 Melhorias futuras

* [x] Tratamento global de exceções
* [x] DTOs para desacoplamento
* [x] Validação com Bean Validation (`@Valid`)
* [ ] Paginação e listagem de usuários
* [ ] Autenticação com JWT
* [ ] Testes automatizados
* [ ] Documentação com Swagger/OpenAPI
* [ ] Password com BCrypt

---

## 👨‍💻 Autor

Desenvolvido por **Arthur Yamamoto**

---
````
