![Java](https://img.shields.io/badge/Java-17%2B-orange?style=flat-square&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0%2B-brightgreen?style=flat-square&logo=springboot)
![Maven](https://img.shields.io/badge/Maven-3.8%2B-C71A36?style=flat-square&logo=apachemaven)

# GameList 🎮

A Spring Boot learning project that serves as a repository for gaming-related information including titles, descriptions, release dates, and other game metadata.

## Overview

GameList is a RESTful API built with Spring Boot designed to manage and retrieve gaming information. This project serves as a practical implementation for learning Spring Boot fundamentals and backend development concepts.

## Features

- Game information management (CRUD operations)
- RESTful API endpoints
- Layered architecture (Controllers <- DTOs -> Services <- Entities/ORM -> Repositories)
- Exception handling
- H2 database for development and testing
- Docker support*
- Deployment readiness*

\* Script for PostgreSQL/pgAdmin containers setup available in `resources/docker-compose.yml`

## Tech Stack

- **Java** - Programming language
- **Spring Boot** - Application framework
- **Spring Data JPA** - Data access layer
- **Maven** - Dependency management and build tool

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- IDE of your choice (IntelliJ IDEA, Eclipse, VS Code)

## Getting Started

### Clone the Repository
```bash
git clone https://github.com/RobertoLJr/gamelist.git
cd gamelist
```

### Build the Project
```bash
mvn clean install
```

### Run the Application
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`  
An H2 console will be available on `http://localhost:8080/h2-console`  
The database will be created and populated with sample data (available in `src/main/resources/import.sql`).

## API Endpoints

*Note: Replace with actual endpoints after reviewing the implementation*

**Games**
```
GET     /games           - Retrieve all games
GET     /games/{id}      - Retrieve a game by ID
```

**GameLists**

```
GET     /game_lists/{id}/games          - Retrieve all games from a particular list
POST    /game_lists/{id}/replacement    - Move a game from a source to target position
```

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/example/gamelist/
│   │       ├── GamelistApplication.java
│   │       ├── controller/
│   │       ├── dto/
│   │       ├── entity/
│   │       ├── exception/
│   │       ├── projection/
│   │       ├── repository/
│   │       └── service/
│   └── resources/
│       ├── application.properties
│       ├── application-test.properties
│       └── import.sql
└── test/
    └── java/
```

## Configuration

The application uses Spring Boot's default configuration. Database and other settings can be modified in `application.properties`.
A test profile for H2 usage is set up in `application-test.properties`.

## Development

This is a learning project focused on:
- Spring Boot application structure
- RESTful API development
- Data modeling and persistence
- Dependency injection
- Best practices in backend development

## Contributing

This is a personal learning project. Feel free to fork and experiment with your own modifications.

## License

This project is for educational purposes.
