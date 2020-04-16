package com.example.homeworkbackend.bootstrap;

import com.example.homeworkbackend.customer.CustomerDTO;
import com.example.homeworkbackend.customer.CustomerEntity;
import com.example.homeworkbackend.customer.CustomerMapper;
import com.example.homeworkbackend.customer.CustomerRepository;
import com.example.homeworkbackend.generator.customer.RandomCustomerData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    private final RandomCustomerData randomCustomerData;
    private final CustomerMapper customerMapper;

    public Bootstrap(CustomerRepository customerRepository,
                     RandomCustomerData randomCustomerData,
                     CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.randomCustomerData = randomCustomerData;
        this.customerMapper = customerMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCustomers();
    }

    private void loadCustomers() {
        for (int i=1; i<51; i++) {
            CustomerDTO dto = randomCustomerData.generateCustomerData();
            CustomerEntity entity = customerMapper.dtoToEntity(dto);
            entity.setId((long) i);
            customerRepository.save(entity);
        }

    }
}
