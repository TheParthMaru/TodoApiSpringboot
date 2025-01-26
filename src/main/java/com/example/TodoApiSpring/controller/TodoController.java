package com.example.TodoApiSpring.controller;

import com.example.TodoApiSpring.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller's task is to take the request and return its response
 */

@RestController
public class TodoController {

    private static List<Todo> todoList;

    public TodoController() {
        todoList = new ArrayList<>();
        todoList.add(new Todo(1, false, "Todo 1", 1));
        todoList.add(new Todo(2, true, "Todo 2", 2));
    }

    /**
     * The ArrayList is being serialized and gets automatically converted to JSON response.
     */

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todoList;
    }

    /**
     * Adding a new todo.
     * Incoming request body is of type Todo.
     * @RequestBody will do seriealize it in Todo form
     */

    // Ways to provide response status
    // 1. @ResponseStatus(HttpStatus.CREATED) below @PostMapping
    // 2. Using ResponseEntity class manually sending response to the client
    @PostMapping("/todos")
    @ResponseStatus(HttpStatus.CREATED)
    public Todo createTodo(@RequestBody Todo newTodo) {
         todoList.add(newTodo);
         return newTodo;
    }

    // 2. Using ResponseEntity class manually sending response to the client
    // Handles things to return to the client manually
//    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo) {
//        todoList.add(newTodo);
//        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
//    }
}
