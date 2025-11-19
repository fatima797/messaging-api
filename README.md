# 💬 Messaging API

A lightweight messaging API built with **Spring Boot 3.5.7**. This project focuses on **clean architecture**, secure user authentication, and defining user roles using **Java Enums**, serving as a focused study for **strengthening backend service development skills**.

---

## ✨ Features

* **RESTful API:** Standardized endpoints for user creation and management.
* **DTO Pattern:** Clear separation of concerns using Data Transfer Objects for request/response mapping.
* **Security:** Secure password hashing using **BCrypt**.
* **Architecture:** Clean **Service/Repository** layer structure.
* **Foundation:** Built on **Spring Boot 3.5.7**

---

## 📦 Tech Stack

| Component | Version / Description |
| :--- | :--- |
| **Backend** | Java 17+ |
| **Framework** | Spring Boot 3.5.7 |
| **Persistence** | Spring Data JPA (Hibernate) |
| **Database** | MySQL |
| **Security** | Spring Security |
| **Build Tool** | Maven |
| **Utility** | Lombok (for boilerplate reduction) |

---

## 🚀 Getting Started

### ✅ Prerequisites

* **JDK 17+**
* **MySQL** database instance running locally.
* **Maven** installed (or use the included `./mvnw` wrapper).

### ⚙️ Setup

1.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/fatima797/messaging-api.git](https://github.com/fatima797/messaging-api.git)
    cd messaging-api
    ```

2.  **Configure Database:**
    Update the connection details in the file `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/messaging_api_db?useSSL=false&serverTimezone=UTC
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    ```

3.  **Build and Run:**
    This command compiles the project and starts the Spring Boot server, which will initialize the schema but will not seed any data.
    ```bash
    ./mvnw clean install
    ./mvnw spring-boot:run
    ```
---

## 🧪 Testing the User Creation Endpoint

Once the application is running on `http://localhost:8080`, you can create a new user using `curl`.

*Note: Role handling in the request body is currently minimal. This request tests basic DTO mapping. **Proper role authorization using Spring Security will be applied in a future iteration.***

```bash
curl -X POST http://localhost:8080/api/users \
-H "Content-Type: application/json" \
-d '{
  "firstName": "Sarah",
  "lastName": "Smith",
  "email": "sarah@example.com",
  "username": "sarah123",
  "password": "pass123",
  "roles": ["ROLE_ADMIN", "ROLE_USER"]
}'
```

---

## Future Improvements
- Complete remainder endpoints for UserService.
- Implement the core MessageService logic.
- Introduce JWT-based authentication and authorization flow.
- Explore migration toward a Microservices architecture.
