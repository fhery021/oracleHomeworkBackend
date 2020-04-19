package com.example.homeworkbackend.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.example.homeworkbackend.JsonReader.readJson;

@SpringBootTest
@AutoConfigureMockMvc
class ServicesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String BASE_URI = "/api/v1/services";

    // create service
    @Test
    void createService() throws Exception {
        mockMvc.perform(post(BASE_URI + "/?customerId=1")
                .content(readJson("/services/createServiceOK.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void createServiceBadRequest() throws Exception {
        mockMvc.perform(post(BASE_URI)
                .content(readJson("/services/createServiceOK.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    // get service by customer id
    @Test
    void getServiceByCustomerId() throws Exception {
        mockMvc.perform(get(BASE_URI + "/customer?customerId=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[1]").isNotEmpty());
    }

    // get all services
    @Test
    void findAllServices() throws Exception {
        mockMvc.perform(get(BASE_URI + "/all").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("[1]").isNotEmpty());
    }

}