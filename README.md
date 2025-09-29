# 🎉 Event Manager

A Spring Boot application to manage events, participants, and registrations.
It allows creating events, registering participants, and managing capacity with validations and a simple frontend built with Thymeleaf.

---

## 🚀 Features

* 📅 Manage events (CRUD operations with capacity & validation)
* 👤 Register participants with validation (@Email, @NotBlank)
* 📝 Register participants to events with capacity check & duplicate prevention
* 🔗 Relationships: Event → Location, Event ↔ Participant (via Registration)
* 🛠️ REST API with Swagger / OpenAPI documentation
* 🌐 Thymeleaf-based frontend for browsing & managing events
* ❌ Global error handling with custom exceptions & JSON responses
* 🧪 Unit and integration tests for services and controllers

---

## 🛠️ Tech Stack

* Java 17+
* Spring Boot

    * Spring Web
    * Spring Data JPA
    * Spring Validation
    * Spring Boot DevTools
    * Spring Boot Test
* MySQL (database)
* Thymeleaf (views)
* OpenAPI / Swagger (API docs)

---

## 📂 Project Structure

```bash
src/main/java/pl/username/eventmanager
│
├── model/           # JPA entities (Event, Participant, Location, Registration)
├── repository/      # Spring Data repositories
├── service/         # Business logic layer
├── controller/      # REST controllers
├── controller/view/ # MVC controllers for Thymeleaf views
├── dto/             # Data Transfer Objects
└── exception/       # Custom exceptions + global handler
```

---

## ⚙️ Configuration

Edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/eventdb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ How to Run

1. Clone the repository:

```bash
git clone https://github.com/username/event-manager
cd event-manager
```

2. Create the database:

```sql
CREATE DATABASE eventdb;
```

3. Configure database credentials in `application.properties`.

4. Start the application:

```bash
./mvnw spring-boot:run
```

5. Access the app:

    * Swagger UI → [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
    * Thymeleaf frontend → [http://localhost:8080/events](http://localhost:8080/events)

---

## 🔮 Roadmap

* 📊 Event pagination & filtering
* 📤 Export participants to CSV
* 📧 Email confirmation for registrations
* 🗺️ Google Maps integration for event locations
* 🐳 Docker support

---

## 📌 Why this project?

This project was built to practice **modular Spring Boot architecture**:

* Entity relationships with JPA
* Layered structure (repository → service → controller)
* REST + MVC endpoints
* Validation & exception handling
* API documentation with Swagger

It demonstrates end-to-end backend development, from database modeling to frontend integration.
