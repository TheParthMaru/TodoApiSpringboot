package com.example.TodoApiSpring.controller;

import com.example.TodoApiSpring.Todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller's task is to take the request and return its response
 */

@RestController
public class TodoController {

    private static List<Todo> todos;

    public TodoController() {
        todos = new ArrayList<>();
        todos.add(new Todo(1, false, "Todo 1", 1));
        todos.add(new Todo(2, true, "Todo 2", 2));
    }

    @GetMapping
}
