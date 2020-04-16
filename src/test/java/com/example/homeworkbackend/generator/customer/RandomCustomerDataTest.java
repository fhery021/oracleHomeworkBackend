package com.example.homeworkbackend.generator.customer;

import com.example.homeworkbackend.customer.CustomerDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomCustomerDataTest {

    RandomCustomerData randomCustomerData = new RandomCustomerData();
    CustomerDTO customerDTO;

    @BeforeEach
    void init() {
        customerDTO = randomCustomerData.generateCustomerData();
    }

    @Test
    void generateCustomerData() {
        assertNotNull(customerDTO);
        assertAll("Should return a generated customer",
                () -> assertNotNull(customerDTO.getName()),
                () -> assertNotNull(customerDTO.getPhoneNumber()),
                () -> assertEquals(customerDTO.getPhoneNumber().length(), 12),
                () -> assertNotNull(customerDTO.getEmailAddress()),
                () -> assertTrue(customerDTO.getEmailAddress().contains("@")),
                () -> assertNotNull(customerDTO.getNetIncome())
                );
    }
}