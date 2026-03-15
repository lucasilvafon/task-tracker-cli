# Task Tracker CLI

Um **Task Tracker simples em linha de comando** desenvolvido em **Java**.
Ele permite criar, listar, atualizar e remover tarefas diretamente pelo terminal.

Este projeto foi criado com o objetivo de praticar conceitos importantes de desenvolvimento backend como:

* Estruturação de projetos Java
* Manipulação de arquivos JSON
* Criação de ferramentas CLI
* Boas práticas de organização de código

---

# Funcionalidades

O programa permite:

* Adicionar tarefas
* Listar tarefas
* Atualizar status de tarefas
* Deletar tarefas
* Persistir dados em JSON

Os status disponíveis são:

* `TODO`
* `IN PROGRESS`
* `DONE`

---

# Estrutura do Projeto

```
task-tracker-cli
│
├─ src
│  └─ main
│     └─ java
│        └─ org/example
│           ├─ Main.java
│           ├─ Task.java
│           ├─ TaskService.java
│           └─ TaskRepository.java
│
├─ tasks.json
├─ build.gradle
└─ README.md
```

Arquitetura utilizada:

```
CLI (Main)
   ↓
Service (TaskService)
   ↓
Storage (TaskStorage)
   ↓
JSON file (tasks.json)
```

---

# Como executar o projeto

## 1. Clonar o repositório

```
git clone https://github.com/seu-usuario/task-tracker-cli.git
```

```
cd task-tracker-cli
```

---

## 2. Compilar o projeto

```
./gradlew build
```

## 3. Executar o programa

```
.\gradlew run --args="comando"

---

# Comandos disponíveis

# Ajuda

Exibe todos os comandos disponíveis do CLI.

 help

Saída no terminal:

Task Tracker CLI

Comandos
add         "descricao"             adicionar tarefa
list                                listar tarefa
update      <id> progress           marcar como em progresso
update      <id> done               marcar como em concluida
delete      <id>                    remover tarefa


Exemplo de saída:


ID  STATUS        DESCRIPTION
--------------------------------
1   TODO          Aprender Java
2   IN PROGRESS   Criar CLI
3   DONE          Configurar Gradle


---

# Armazenamento de dados

As tarefas são armazenadas no arquivo:

tasks.json


Exemplo:

[
  {
    "id": 1,
    "description": "Aprender Java",
    "status": "TODO"
  }
]

---

# Tecnologias utilizadas

* Java
* Gradle
* Gson (para manipulação de JSON)

---

* comando `help`
* geração de executável `.exe`

---
```
## 4. Autor
Lucas Fonseca

Reference: https://roadmap.sh/projects/task-tracker

Projeto criado para estudo de **Java e desenvolvimento backend**.
