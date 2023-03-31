package com.exam.todoservice.controllers;

import com.exam.todoservice.entity.Todo;
import com.exam.todoservice.repository.TodoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TodoCrudControllersTest {

    private MockMvc mockMvc;

    @Autowired
    private TodoRepository repository;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new TodoCrudControllers()).build();
    }

    @Test
    void test1() throws Exception {
        this.mockMvc.perform(get("/api/basicCruds/")
                        .accept(MediaType.parseMediaType("application/json")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void createTodos() {
    }

    @Test
    void getAllTodos() {
    }

    @Test
    void getTodosById() {
    }

    @Test
    void getTodosByUserId() {
    }

    @Test
    void updateTodos() {
    }

    @Test
    void deleteTodos() {
    }
}