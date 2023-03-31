package com.exam.todoservice.controllers;

import com.exam.todoservice.entity.Todo;
import com.exam.todoservice.exceptions.ResourceNotFoundException;
import com.exam.todoservice.repository.TodoRepository;
import com.exam.todoservice.service.TodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/basicCruds")
public class TodoCrudControllers {

    @Autowired
    private TodoRepository todoRepository;
    private TodoServices services;

    @GetMapping("/")
    public String test() {
        return "hello world service";
    }

    //create
    @PostMapping("/todos")
    public Todo createTodos(@RequestBody Todo todo) {
        return services.createTodos(todo);
    }

    //read
    @GetMapping("/todos")
    public Iterable< Todo > getAllTodos() {
        return services.getAllTodos();
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity < Todo > getTodosById(@PathVariable(value = "id") Integer todoId) throws ResourceNotFoundException {
        return services.getTodosById(todoId);
    }


    @GetMapping("/todosByUser/{id}")
    public ResponseEntity <List<Todo>> getTodosByUserId(@PathVariable(value = "id") Integer userId) throws ResourceNotFoundException {
        return services.getTodosByUserId(userId);
    }

    //update
    @PutMapping("/employees/{id}")
    public ResponseEntity < Todo > updateTodos(@PathVariable(value = "id") Integer todoId, @RequestBody Todo todoDetails) throws ResourceNotFoundException {
        return services.updateTodos(todoId, todoDetails);
    }


    //delete
    @DeleteMapping("/todos/{id}")
    public Map< String, Boolean > deleteTodos(@PathVariable(value = "id") Integer todoId)
            throws ResourceNotFoundException {
        return services.deleteTodos(todoId);
    }

}
