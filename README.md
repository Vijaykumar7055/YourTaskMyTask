# YourTaskMyTask – CRM Backend

A Customer Relationship Management (CRM) application backend developed using **Java, Spring Boot, Spring Data JPA, Hibernate, and PostgreSQL**.

The application helps manage customers, employees, and follow-up activities through RESTful APIs.

## 🚀 Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate ORM
- PostgreSQL
- Maven
- Lombok
- Jakarta Bean Validation
- REST APIs
- Postman

## 📌 Features

### 1. Authentication
- User Registration
- User Login
- Basic authentication APIs

### 2. Employee Management
- Add new employees
- Get all employees
- Get employee by ID
- Update employee details
- Delete employees

### 3. Customer Management
- Add new customers
- Get all customers
- Get customer by ID
- Update customer details
- Delete customers

### 4. Follow-Up Management
- Create customer follow-ups
- Get all follow-ups
- Get follow-up by ID
- Update follow-up details
- Delete follow-ups
- Get follow-ups by customer ID
- Get follow-ups by employee ID

### 5. Validation & Exception Handling
- Request validation using Jakarta Validation
- Custom ResourceNotFoundException
- Global exception handling

## 👥 User Roles

| Role | Description |
|---|---|
| ADMIN | Manages employee records |
| EMP | Handles customer and follow-up activities |
| USER | General user role |

*Role-based API authorization is a planned security enhancement; the above roles describe the intended application responsibilities.*

## 🏗️ Project Architecture

```text
React Frontend
      |
      | REST API (Axios)
      |
Spring Boot Backend
      |
      v
Controller Layer
      |
      v
Service Layer
      |
      v
Repository Layer
      |
      v
Hibernate / JPA
      |
      v
PostgreSQL Database
```

## 📂 Backend Folder Structure

```text
src/main/java/com/yourtaskmytask/yourtaskmytask/
│
├── controller/
│   ├── AuthController.java
│   ├── AdminController.java
│   ├── CustomerController.java
│   └── FollowUpController.java
│
├── entity/
│   ├── User.java
│   ├── Customer.java
│   └── FollowUp.java
│
├── repository/
│   ├── UserRepository.java
│   ├── CustomerRepository.java
│   └── FollowUpRepository.java
│
├── service/
│   ├── AuthService.java
│   ├── AdminService.java
│   ├── CustomerService.java
│   └── FollowUpService.java
│
├── exception/
│   ├── ResourceNotFoundException.java
│   └── GlobalExceptionHandler.java
│
├── config/
│   └── CorsConfig.java
│
└── YourtaskmytaskApplication.java
```

*Adjust the folder structure according to the actual files in your repository.*

## 🔗 REST API Endpoints

### Authentication APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/auth/register` | Register a user |
| POST | `/api/auth/login` | User login |

### Employee APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/admin/employees` | Add employee |
| GET | `/api/admin/employees` | Get all employees |
| GET | `/api/admin/employees/{id}` | Get employee by ID |
| PUT | `/api/admin/employees/{id}` | Update employee |
| DELETE | `/api/admin/employees/{id}` | Delete employee |

### Customer APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/customers` | Add customer |
| GET | `/api/customers` | Get all customers |
| GET | `/api/customers/{id}` | Get customer by ID |
| PUT | `/api/customers/{id}` | Update customer |
| DELETE | `/api/customers/{id}` | Delete customer |

### Follow-Up APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/followups` | Create follow-up |
| GET | `/api/followups` | Get all follow-ups |
| GET | `/api/followups/{id}` | Get follow-up by ID |
| PUT | `/api/followups/{id}` | Update follow-up |
| DELETE | `/api/followups/{id}` | Delete follow-up |
| GET | `/api/followups/customer/{customerId}` | Get customer follow-ups |
| GET | `/api/followups/employee/{employeeId}` | Get employee follow-ups |

## 🗄️ Database Configuration

This project uses PostgreSQL as its relational database.

Create a database:

```sql
CREATE DATABASE yourtaskmytask;
```

Configure `src/main/resources/application.properties`:

```properties
spring.application.name=yourtaskmytask

spring.datasource.url=jdbc:postgresql://localhost:5432/yourtaskmytask
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD

spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8080
```

Replace the database username and password with your local PostgreSQL credentials.

## ⚙️ Installation & Setup

### Prerequisites

- Java 21 or higher
- Maven
- PostgreSQL
- IntelliJ IDEA or any Java IDE
- Postman

### Step 1: Clone Repository

```bash
git clone YOUR_BACKEND_REPOSITORY_URL
```

### Step 2: Open Project

Open the cloned backend project in IntelliJ IDEA.

### Step 3: Configure Database

Create the PostgreSQL database and update the database credentials in `application.properties`.

### Step 4: Run Application

Using Maven:

```bash
mvn spring-boot:run
```

Or run the main Spring Boot application class from IntelliJ IDEA.

### Step 5: Test APIs

Use Postman to test the REST API endpoints.

Backend runs at:

```text
http://localhost:8080
```

## 🔄 Entity Relationships

- One Customer can have multiple Follow-Ups.
- One Employee can handle multiple Follow-Ups.
- Every Follow-Up belongs to one Customer and one Employee.

## 🔐 Security Notes

The current backend includes basic registration and login APIs. Password hashing, JWT-based authentication, and complete role-based authorization are security enhancements to be implemented before production deployment.

## 👨‍💻 Developer

**Vijay Kumar**

- GitHub: [vijaykumar7055](https://github.com/vijaykumar7055)
- Portfolio: [vijayweb18.vercel.app](https://vijayweb18.vercel.app)

## 📄 License

This project is developed for learning and portfolio purposes.
