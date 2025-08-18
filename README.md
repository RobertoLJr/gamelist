# GameList 🎮

A Spring Boot learning project that serves as a repository for gaming-related information including titles, descriptions, release dates, and other game metadata.

## Overview

GameList is a RESTful API built with Spring Boot designed to manage and retrieve gaming information. This project serves as a practical implementation for learning Spring Boot fundamentals and backend development concepts.

## Features

- Game information management (CRUD operations)
- RESTful API endpoints
- Data persistence layer
- Game metadata storage (title, release year, genre, platform, score, cover image, short and long descriptions)

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

## API Endpoints

*Note: Replace with actual endpoints after reviewing the implementation*

```
GET    /games          - Retrieve all games
GET    /games/{id}     - Retrieve game by ID    [NOT YET IMPLEMENTED]
POST   /games          - Create new game        [NOT YET IMPLEMENTED]
PUT    /games/{id}     - Update existing game   [NOT YET IMPLEMENTED]
DELETE /games/{id}     - Delete game            [NOT YET IMPLEMENTED]
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
