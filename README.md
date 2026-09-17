# spring-boot-crud-operations

This is a Spring Boot application demonstrating CRUD operations.

## Prerequisites

- Java 17 or higher
- Maven (optional, Maven wrapper is included)

## Execution Steps

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd spring-boot-developer-toolkit
   ```

2. **Build the project**:
   - On Windows:
     ```cmd
     mvnw.cmd clean install
     ```
   - On Linux/Mac:
     ```bash
     ./mvnw clean install
     ```

3. **Run the application**:
   - On Windows:
     ```cmd
     mvnw.cmd spring-boot:run
     ```
   - On Linux/Mac:
     ```bash
     ./mvnw spring-boot:run
     ```

## Accessing the Application
Once the application starts, it can be accessed at `http://localhost:8080`.

### Sample Requests

**1. Hello World (GET):**
```http
GET http://localhost:8080/hello
```

**2. User Login (POST):**
```http
POST http://localhost:8080/api/login
```

**3. User Registration (POST):**
```http
POST http://localhost:8080/api/register
```

**4. Get All Users (GET):**
```http
GET http://localhost:8080/api/users
```

**5. Update User (PUT):**
```http
PUT http://localhost:8080/api/users/{id}
```

**6. Delete User (DELETE):**
```http
DELETE http://localhost:8080/api/users/{id}
```
