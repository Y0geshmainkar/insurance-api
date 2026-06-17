# insurance-api

A RESTful backend API for managing insurance policies, built with Spring Boot 3 and Spring Data JPA. Demonstrates clean layered architecture (Controller → Service → Repository), full CRUD operations, in-memory H2 database, and Docker containerization with a multi-stage build.

Designed as the backend companion to [PolicyHub](https://github.com/Y0geshmainkar/policyhub) — the React frontend portal.

---

## Tech Stack

| Layer | Technology |
|---|---|
| Framework | Spring Boot 3.2 |
| Language | Java 17 |
| Persistence | Spring Data JPA + H2 (in-memory) |
| Build | Maven |
| Container | Docker (multi-stage build) |
| CI/CD | GitHub Actions |

---

## API Endpoints

Base URL: `/api/policies`

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/policies` | Get all policies |
| GET | `/api/policies/{id}` | Get policy by ID |
| POST | `/api/policies` | Create a new policy |
| PUT | `/api/policies/{id}` | Update a policy |
| DELETE | `/api/policies/{id}` | Delete a policy |

### Policy Schema

```json
{
  "id": 1,
  "policyNumber": "POL-001",
  "holderName": "Jane Smith",
  "type": "LIFE",
  "premium": 250.00,
  "status": "ACTIVE"
}
```

| Field | Type | Values |
|---|---|---|
| `type` | String | `LIFE`, `HEALTH`, `AUTO` |
| `status` | String | `ACTIVE`, `INACTIVE` |

---

## Getting Started

### Run locally

```bash
mvn spring-boot:run
```

API available at `http://localhost:8080`

### Run with Docker

```bash
docker build -t insurance-api .
docker run -p 8080:8080 insurance-api
```

### Run tests

```bash
mvn test
```

---

## Project Structure

```
src/main/java/com/yogesh/insuranceapi/
├── controller/    # PolicyController — REST endpoints
├── service/       # PolicyService — business logic
├── repository/    # PolicyRepository — Spring Data JPA
└── model/         # Policy — JPA entity
```

---

## CI/CD

Pushes to `main` or `develop` trigger:
1. **Build** — `mvn clean package`
2. **Test** — `mvn test`
