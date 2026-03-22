# Lab1-Springboot
📚 Book Management System

🚀 Funktioner

    Fullständigt CRUD: Skapa, läsa, uppdatera och radera böcker.

    Paginering & Sortering: Effektiv hantering av stora boklistor.

    Kontaktformulär: Ett validerat formulär som sparar kundmeddelanden i en separat databastabell.

    Datavalidering: Robust hantering av indata med Bean Validation (Hibernate Validator).

    🛠 Teknisk Stack

    Backend: Java 25, Spring Boot 3.4.x, Spring Data JPA.

    Databas: PostgreSQL.

    Frontend: Thymeleaf, CSS3, JavaScript.

    Testning: JUnit 5, Mockito, MockMvc.

    📦 Installation & Körning
    
    Förutsättningar

    Java 21 eller högre.

    Maven.

    En körande PostgreSQL-instans.

    🧪 Testning

Projektet använder en test-driven approach med hög täckning:

    Unit Tests: Mappers och domänlogik.

    Service Tests: Affärslogik med Mockito-mocks.

    Integration Tests: Webblager-tester med MockMvc och Repository-tester med @DataJpaTest.

    Kör alla tester med:
    Bash

  mvn test

  Starta applikationen

  docker-compose up -d

  
