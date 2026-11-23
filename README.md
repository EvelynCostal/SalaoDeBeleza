# Sistema de Agendamento

Sistema web para marcação e gerenciamento de horários, construído para evitar choques de agendamento tanto na interface quanto na persistência dos dados.

![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15%2B-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-ES6+-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)

---

## Como funciona

O projeto resolve o problema de horários duplicados atuando em três frentes:

* **Filtragem em tempo real:** Ao selecionar uma data no formulário, o front-end consulta a API e oculta automaticamente os horários que já estão reservados naquele dia.
* **Validação na API:** Caso duas pessoas tentem reservar o mesmo horário simultaneamente, o back-end intercepta a violação de integridade e responde com HTTP `409 Conflict`, exibindo um alerta visual na tela.
* **Trava no banco de dados:** A tabela no PostgreSQL possui uma restrição `UNIQUE` composta entre `data` e `horario`, garantindo que nenhum registro duplicado seja gravado mesmo fora da aplicação.

---

## Tecnologias

* **Back-end:** Java (17 ou 21), Spring Boot (Spring Web, Spring Data JPA)
* **Banco de Dados:** PostgreSQL
* **Front-end:** HTML5, CSS3, JavaScript (Fetch API)

---

## Estrutura de Pastas

```text
sistema-agendamento/
├── backend/
│   ├── src/main/java/com/exemplo/agendamento/
│   │   ├── controller/
│   │   │   └── AgendamentoController.java
│   │   ├── model/
│   │   │   └── Agendamento.java
│   │   └── repository/
│   │       └── AgendamentoRepository.java
│   ├── src/main/resources/
│   │   └── application.properties
│   └── pom.xml
└── frontend/
    ├── index.html
    ├── style.css
    └── script.js
