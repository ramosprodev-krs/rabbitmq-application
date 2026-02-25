# <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg" width="40" height="40"> sql-ecommerce-application
**Project Start Date: January 15, 2026  
Completion Date: February 10, 2026**

This project was developed in **Java** using the **Spring Boot 3.4** ecosystem.  
A robust E-commerce application focused on **security**, **data persistence**, and **cloud service integration (AWS)**.

### Technologies used:
- **Java 21** (Spring Framework)
- **Spring Security & JWT**: Stateless authentication and authorization.
- **Spring Data JPA**: Database abstraction and persistence.
- **PostgreSQL**: Relational database for high data integrity.
- **AWS SES (Simple Email Service)**: Automated welcome email configuration.
- **Swagger (OpenAPI 3)**: Interactive documentation and endpoint testing.
- **Docker**: Containerization for the database and environment.
- **Lombok**: Productivity and reduction of boilerplate code.
- **Insomnia**: Validation and testing of API routes.

---

## 🧭 Quick Navigation  
- 🐳 [Running with Docker & PostgreSQL (Guide)](./docs/docker-setup-guide.md)
- 🔐 [Authentication & Security Flow (JWT)](./docs/security-documentation.md)
- 📄 [API Documentation (Swagger/OpenAPI)](./docs/api-docs.md)
- 📩 [Contact me!](./docs/contact-me.md)

---

## 🛠️ Architectural Highlights

Reflecting the philosophy that **"small choices change the course of our lives,"** this project implements technical decisions that ensure system security and scalability:

* **MVC Pattern + Service Layer**: Clear separation between data entry (Controllers), business logic (Services), and persistence (Repositories).
* **Security Configuration**: Implementation of a customized `SecurityFilterChain` that manages permissions by roles (`USER`, `MANAGER`, `ADMIN`) and integrates JWT tokens via Bearer headers in Swagger.
* **Cloud Integration**: The use of **Amazon SES** demonstrates the ability to integrate the application with real cloud infrastructure to automate customer communication.



---

## 🚀 How to Run (Quick Start)

### 1. Database Setup
To quickly spin up PostgreSQL:
```bash
docker run --name ecommerce-db -e POSTGRES_PASSWORD=yourpassword -p 5432:5432 -d postgres
```

---
### 2. Conteúdo para o `docs/docker-setup-guide.md`
# 🐳 Running the application with Docker (Guide)

### Setting things first
Before proceeding, ensure you have the following tools properly installed on your system:  
- [Java Development Kit (JDK 21)](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)  
- [Docker Engine / Docker Desktop](https://www.docker.com/products/docker-desktop/)  
- [Insomnia](https://insomnia.rest/download) or [Postman](https://www.postman.com/downloads/)

---

## The use of "docker-compose.yml"
This project includes a **docker-compose.yml** file designed to orchestrate the **PostgreSQL** database and the **Spring Boot** application containers seamlessly.

### 1. **Clone the repository** ```bash
git clone [https://github.com/KalRSilva/sql-ecommerce-application.git](https://github.com/KalRSilva/sql-ecommerce-application.git)
cd sql-ecommerce-application
