# Desafio_do_Forum_Hub_da_Alura

📚 **ForumHub - API de Fórum Acadêmico**
ForumHub é uma API RESTful desenvolvida em Spring Boot para gerenciamento de tópicos em um fórum acadêmico, permitindo a criação, listagem, atualização e exclusão de discussões sobre diversos cursos.

🚀 **Funcionalidades**
CRUD Completo de Tópicos: Create, Read, Update e Delete de discussões

Paginação: Listagem paginada de tópicos com ordenação

Validação de Dados: Validação automática dos campos obrigatórios

Entidade Embeddable: Estrutura de cursos incorporada nos tópicos

API RESTful: Endpoints bem definidos seguindo padrões REST

🛠️ **Tecnologias Utilizadas:**

-Java 21

-Spring Boot 3.5.4

-Spring Data JPA

-MySQL Database

-Lombok

📋 **Endpoints da API**
Tópicos
| Método   | Endpoint            | Descrição                               |
|----------|---------------------|-----------------------------------------|
| `POST`   | `/topicos`          | Cria um novo tópico                     |
| `GET`    | `/topicos`          | Lista todos os tópicos (com paginação)  |
| `GET`    | `/topicos/{id}`     | Busca um tópico específico por ID       |
| `PUT`    | `/topicos`          | Atualiza um tópico existente            |
| `DELETE` | `/topicos/{id}`     | Exclui um tópico (exclusão lógica)      |

### Estrutura do JSON

```bash
-Request (POST/PUT):

{
  "titulo": "Dúvida sobre Spring Boot",
  "mensagem": "Como configurar autenticação?",
  "autor": "João Silva",
  "respostas": "Nenhuma resposta ainda",
  "curso": {
    "nome": "Java",
    "categoria": "Programação"
  }
}

-Response:
{
  "id": 1,
  "titulo": "Dúvida sobre Spring Boot",
  "mensagem": "Como configurar autenticação?",
  "autor": "João Silva",
  "respostas": "Nenhuma resposta ainda",
  "dataCriacao": "2024-01-20T10:30:00.000Z",
  "curso": {
    "nome": "Java",
    "categoria": "Programação"
  }
}

## 📂 Estrutura do Projeto

```bash
forum-api
├── src
│   └── main
│       ├── java
│       │   └── forumHub
│       │       └── alura
│       │           └── forumApi
│       │               ├── ForumApiApplication.java
│       │               ├── controller
│       │               │   └── ApiController.java
│       │               ├── Topicos
│       │               │   ├── Topicos.java
│       │               │   ├── ApiRepository.java
│       │               │   ├── DadosCadastroTopicos.java
│       │               │   ├── DadosListagemTopicos.java
│       │               │   ├── DadosDetalhamentoTopicos.java
│       │               │   └── DadosAtualizacaoTopicos.java
│       │               └── curso
│       │                   ├── Curso.java
│       │                   └── DadosCurso.java
│       └── resources
│           └── application.properties
└── pom.xml
