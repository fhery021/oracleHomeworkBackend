package com.example.homeworkbackend.bootstrap;

import com.example.homeworkbackend.customer.CustomerEntity;
import com.example.homeworkbackend.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public Bootstrap(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCustomers();
    }

    private void loadCustomers() {
        CustomerEntity customerEntity = CustomerEntity.builder()
                .id(1L)
                .name("John")
                .cityName("New York")
                .phoneNumber("+36 12 345 6789")
                .emailAddress("johnn@gmail.com")
                .netIncome(1000L)
                .build();
        customerRepository.save(customerEntity);
    }
}
