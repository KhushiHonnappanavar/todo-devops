# Todo REST API

A simple Spring Boot REST API for managing todo items. Todos are stored in memory while the application is running.

## Run the application

Run `mvn spring-boot:run` from the project folder.

The API runs at `http://localhost:8080`.

## Endpoints

- `GET /health` checks that the API is running.
- `GET /todos` lists todos.
- `POST /todos` adds a todo.

Example POST body: `{"title":"Complete DevOps assignment"}`
