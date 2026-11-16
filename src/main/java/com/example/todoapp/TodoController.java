package com.example.todoapp;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TodoController {

    private final List<Todo> todos = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    // GET: View all todos
    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todos;
    }

    // POST: Add a new todo
    @PostMapping("/todos")
    public Todo addTodo(@RequestBody TodoRequest request) {
        Todo todo = new Todo(
            counter.incrementAndGet(),
            request.title(),
            false
        );

        todos.add(todo);
        return todo;
    }

    // GET: Check API health
    @GetMapping("/health")
    public String health() {
        return "Todo API is running successfully!";
    }

    // Todo data
    public record Todo(long id, String title, boolean completed) {}

    // Request data
    public record TodoRequest(String title) {}
}
