package com.exam.todoservice.service;

import com.exam.todoservice.entity.Todo;
import com.exam.todoservice.exceptions.ResourceNotFoundException;
import com.exam.todoservice.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
//@Transactional
public class TodoServices {

    private final TodoRepository todoRepository;
    private final WebClient webClient;

    public Todo createTodos(Todo todo) {
        // make sure user id is correct
        // check the user status be fore creating todos
        return todoRepository.save(todo);
    }

    public Iterable<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public ResponseEntity<Todo> getTodosById(Integer todoId) throws ResourceNotFoundException {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new ResourceNotFoundException("Todos not found for this id :: " + todoId));
        return ResponseEntity.ok().body(todo);
    }

    public ResponseEntity<List<Todo>> getTodosByUserId(Integer userId) throws ResourceNotFoundException {
        List<Todo> todo = todoRepository.findByUser(userId).orElseThrow(() -> new ResourceNotFoundException("Todos not found for this id :: " + userId));
        return ResponseEntity.ok().body(todo);
    }

    public ResponseEntity<Todo> updateTodos(Integer todoId, Todo todoDetails) throws ResourceNotFoundException {
        //todo: check if the user is correct

        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new ResourceNotFoundException("Todos not found for this id :: " + todoId));

        int userId = todo.getUser();
        Boolean result = webClient.get()
                .uri("http://localhost:8081/api/userCruds/todos/check/{userId}",userId)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();

        if (result) {
            todo.setName(todoDetails.getName());
            todo.setDescription(todoDetails.getDescription());
            final Todo updatedTodo = todoRepository.save(todo);
            return ResponseEntity.ok(updatedTodo);
        }
        return ResponseEntity.ok(new Todo()); // needs to be checked
    }

    public Map<String, Boolean> deleteTodos(Integer todoId) throws ResourceNotFoundException {
        //todo: check if the user is correct
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new ResourceNotFoundException("Todos not found for this id :: " + todoId));
        int userId = todo.getUser();
        Boolean result = webClient.get()
                .uri("http://localhost:8081/api/userCruds/todos/check/{userId}",userId)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        Map<String, Boolean> response = new HashMap<>();

        if (result) {
            todoRepository.delete(todo);
            response.put("deleted", Boolean.TRUE);
            return response;
        }
        response.put("cant delete", Boolean.FALSE);
        return response;
    }
}
