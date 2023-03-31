package com.exam.todoservice.controllers;

import com.exam.todoservice.entity.Todo;
import com.exam.todoservice.repository.TodoRepository;
import com.exam.todoservice.service.TodoServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@RestClientTest(TodoServices.class)
class TodoCrudControllersTest {

    private MockMvc mockMvc;

    @Autowired
    private TodoRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    private MockRestServiceServer server;

    @BeforeEach
    void setUp() throws JsonProcessingException {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new TodoCrudControllers()).build();
        String detailsString = objectMapper.writeValueAsString( new Todo("Name","name1", 1));
        this.server.expect(requestTo("/api/basicCruds/todos")).andRespond(withSuccess(detailsString, MediaType.APPLICATION_JSON));
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