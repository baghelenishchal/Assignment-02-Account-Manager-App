# Account Management API

This is a Spring Boot application that provides an Account Management API. The application supports basic CRUD (Create, Read, Update) operations for managing accounts, with secure endpoints protected using Basic Authentication.

## Features

- **CRUD Operations**:
    - Create a new account
    - Retrieve all accounts (with pagination support)
    - Retrieve an account by its number or name
    - Update an existing account

- **Database**: MySQL (H2 is also used for testing purposes)

- **Security**: Basic Authentication to secure API endpoints.

- **Unit and Integration Tests**: Test-driven development (TDD) approach with unit and integration tests.

## Requirements

- Java 17 or higher
- MySQL database (for production) or H2 (in-memory for testing)
- Maven or Gradle for building the application

## Setup

### 1. Clone the Repository

Clone the repository to your local machine using the following command:

```
git clone https://github.com/yourusername/account-management-api.git
cd account-management-api

# 2. Build and Run the Application
To build and run the application, use Maven:

mvn clean install
mvn spring-boot:run


# 3. Accessing the H2 Console
To access the H2 console for development or testing purposes:

Navigate to http://localhost:9991/h2-console in your browser.
Login with the default credentials:
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: password

The Postman Collections can be found inside resources folder for API testing purposes.
