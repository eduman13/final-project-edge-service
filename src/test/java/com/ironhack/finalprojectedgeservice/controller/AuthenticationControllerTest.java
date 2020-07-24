package com.ironhack.finalprojectedgeservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.finalprojectedgeservice.model.dto.UserDTO;
import com.ironhack.finalprojectedgeservice.model.security.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class AuthenticationControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    void login() throws Exception {
        User user = new User();
            user.setUsername("admin");
            user.setPassword("admin");
        this.mockMvc.perform(post("/login")
                .content(objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void findByUsername() throws Exception {
        this.mockMvc.perform(get("/user/find_by_username")
                .param("username", "doctor1"))
                .andExpect(status().isOk());
    }

    @Test
    void createUser() throws Exception {
        UserDTO userDTO = new UserDTO();
            userDTO.setUsername("eduardo");
            userDTO.setPassword("eduardo");
        this.mockMvc.perform(post("/user/create_user")
                .content(objectMapper.writeValueAsString(userDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}