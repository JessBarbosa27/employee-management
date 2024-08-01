# Employee Management System

## Overview

This project is a simple Employee Management System developed using Spring Boot. It provides basic CRUD (Create, Read, Update, Delete) operations for managing employee data. The application exposes REST APIs for these operations.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- H2 Database
- Mockito
- JUnit

## Project Structure

- `src/main/java/com/geoplace/techinal_test/employee_management/`
  - `controller/` - Contains the REST controller classes.
  - `model/` - Contains the entity classes.
  - `repository/` - Contains the repository interfaces.
  - `service/` - Contains the service interfaces and their implementations.
  - `exception/` - Contains custom exception classes.
  - `EmployeeManagementApplication.java` - The main application class.

- `src/test/java/com/geoplace/techinal_test/employee_management/`
  - `controller/` - Contains the test classes for controllers.
  - `service/` - Contains the test classes for services.

## Setup Instructions

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/JessBarbosa27/employee-management
   cd employee-management
   
## Swagger

1. **Access Swagger:** http://localhost:8080/swagger-ui/index.html#/

## H2 Database

1. **Access DB:** http://localhost:8080/h2-console
2. Credentials:
   - username: sa
   - password: password
