package com.exam.userservice.controllers;

import com.exam.userservice.entity.AppUser;
import com.exam.userservice.repository.AppUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserCrudControllersTest {
    private MockMvc mockMvc;

    @Autowired
    private AppUserRepository repository;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new UserCrudControllers()).build();
    }

    @Test
    void test1() throws Exception {
        this.mockMvc.perform(get("/api/userCruds/")
                        .accept(MediaType.parseMediaType("application/json")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void createUser() throws Exception {
        AppUser user = new AppUser("samson", "sami", true);

    }

    @Test
    void getAllUsers() {
    }

    @Test
    void getUsersById() {
    }

    @Test
    void updateUsers() {
    }

    @Test
    void deleteUsers() {
    }

    @Test
    void isChecked() {
    }
}