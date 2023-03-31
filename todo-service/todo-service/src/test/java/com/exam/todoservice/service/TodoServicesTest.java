package com.exam.todoservice.service;

import com.exam.todoservice.entity.Todo;
import com.exam.todoservice.repository.TodoRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
class TodoServicesTest {

    @Autowired
    private TodoRepository todoRepository;

//    @Autowired
//    private TodoServices todoServices;

    @Test
    void createTodos() {
        Todo todo = new Todo("name", "description", 1);
        Todo todos = todoRepository.save(todo);
        assertThat(todos).isNotNull();
    }

    @Test
    void getAllTodos() {
        Todo todo = new Todo("name", "description", 2);
        Todo save = todoRepository.save(todo);
        assertThat(save).isNotNull();
    }

    @Test
    void getTodosById() {
    }

    @Test
    void getTodosByUserId() {
    }
}