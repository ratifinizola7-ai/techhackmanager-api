# 🚀 TechHackManager API

API RESTful desenvolvida em **Java** com **Spring Boot** para a gestão de equipas, projetos e notas no âmbito de hackathons e eventos de tecnologia.

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.2.5**
- **Spring Data JPA** (Persistência de dados)
- **H2 Database** (Base de dados em memória para desenvolvimento/testes)
- **Spring Boot Validation** (Validação de dados com `@Valid`, `@NotBlank`, etc.)
- **SpringDoc OpenAPI / Swagger UI** (Documentação interativa da API)
- **Maven** (Gestor de dependências)

---

## 📌 Funcionalidades (CRUD de Equipas)

- **Criar Equipa (`POST /api/equipes`)**: Cadastra uma nova equipa com validação de campos obrigatórios.
- **Listar Equipas (`GET /api/equipes`)**: Retorna todas as equipas registadas.
- **Buscar por ID (`GET /api/equipes/{id}`)**: Retorna os detalhes de uma equipa específica ou `404 Not Found`.
- **Atualizar Equipa (`PUT /api/equipes/{id}`)**: Atualiza os dados de uma equipa existente.
- **Apagar Equipa (`DELETE /api/equipes/{id}`)**: Remove uma equipa da base de dados.

---

## 📖 Documentação Interativa (Swagger)

Com a aplicação em execução, podes aceder à interface interativa do Swagger para testar todos os endpoints diretamente pelo navegador:

📍 **URL do Swagger:** [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 🚀 Como Executar o Projeto

1. **Clonar o repositório:**
   ```bash
   git clone [https://github.com/teu-usuario/techhackmanager-api.git](https://github.com/teu-usuario/techhackmanager-api.git)

    aceder a pasta do projeto:
   cd techhackmanager-api
   
    Executar a aplicação(terminal): 
   ./mvnw spring-boot:run
   
    A API estará disponível em: 
   http://localhost:8080
   
    Estrutura do Projeto: 
   ```src/main/java/com/example/demo/
├── model/
│    └── Equipe.java
├── repository/
│    └── EquipeRepository.java
└── controller/
└── EquipeController.java