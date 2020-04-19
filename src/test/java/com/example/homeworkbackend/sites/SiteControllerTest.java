package com.example.homeworkbackend.sites;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.homeworkbackend.JsonReader.readJson;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SiteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String BASE_URI = "/api/v1/site";

    @Test
    void createSite() throws Exception {
        mockMvc.perform(post(BASE_URI + "/?customerId=1")
                .content(readJson("/site/createSiteOk.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void createSiteBadRequest() throws Exception {
        mockMvc.perform(post(BASE_URI)
                .content(readJson("/site/createSiteOk.json"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getSitesByCustomerId() throws Exception {
        mockMvc.perform(get(BASE_URI + "/customer?customerId=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[1]").isNotEmpty());
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get(BASE_URI + "/all").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[1]").isNotEmpty());
    }
}