package com.example.TodoApiSpring.controller;

import com.example.TodoApiSpring.Todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
     * @return
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
    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo newTodo) {
         todoList.add(newTodo);
         return newTodo;
    }
}
