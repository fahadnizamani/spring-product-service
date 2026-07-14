# Product Service

A production-style Spring Boot microservice responsible for product management in an e-commerce application.

This service was extracted from a modular monolith as part of a gradual migration to a microservices architecture.

---

## Architecture

```
                React Frontend
                       │
                       ▼
               Spring Cloud Gateway
                       │
          ┌────────────┴────────────┐
          ▼                         ▼
     demo-app                 product-service
(Auth, Cart, Orders)          (Products)
```

The API Gateway routes all product-related requests to this service.

---

## Responsibilities

- Product Management
- Product Lookup
- Inventory Validation
- Product CRUD APIs
- Product Caching using Redis (if enabled)

This service is consumed by other services (currently `demo-app`) through REST APIs using Spring WebClient.

---

## Technology Stack

- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA
- PostgreSQL
- Redis Cache
- Maven
- Docker
- Docker Compose
- GitHub Actions (CI/CD)

---

## Features

- RESTful Product APIs
- PostgreSQL persistence
- Product lookup by ID
- Inventory validation
- Spring Cache support
- Service-to-service communication
- Production-ready layered architecture

---

## API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/api/products` | Get all products |
| GET | `/api/products/{id}` | Get product by ID |
| POST | `/api/products` | Create product |
| PUT | `/api/products/{id}` | Update product |
| DELETE | `/api/products/{id}` | Delete product |

---

## Running Locally

### Clone Repository

```bash
git clone https://github.com/fahadnizamani/product-service.git
```

### Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/demo_db
spring.datasource.username=postgres
spring.datasource.password=your_password
```

### Run

```bash
mvn spring-boot:run
```

The service starts on:

```
http://localhost:8082
```

---

## Sample Request

```
GET http://localhost:8082/api/products/1
```

---

## Future Enhancements

- JWT Authentication
- Service Discovery (Eureka)
- Circuit Breaker (Resilience4j)
- Docker Containerization
- Kubernetes Deployment
- Distributed Tracing (OpenTelemetry + Jaeger)
- Prometheus & Grafana Monitoring

---

## Related Projects

- **demo-app** – Authentication, Cart, Orders
- **spring-cloud-api-gateway** – API Gateway
- **ecommerce-frontend** – React Frontend

---

## Author

**Fahad Nizamani**

Senior Java Backend Engineer

Java • Spring Boot • Microservices • Kafka • Redis • PostgreSQL • Docker • Kubernetes