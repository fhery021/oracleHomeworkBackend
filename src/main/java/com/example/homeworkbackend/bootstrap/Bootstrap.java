package com.example.homeworkbackend.bootstrap;

import com.example.homeworkbackend.customer.CustomerDTO;
import com.example.homeworkbackend.customer.CustomerEntity;
import com.example.homeworkbackend.customer.CustomerMapper;
import com.example.homeworkbackend.customer.CustomerRepository;
import com.example.homeworkbackend.generator.customer.RandomCustomerData;
import com.example.homeworkbackend.generator.services.RandomServicesData;
import com.example.homeworkbackend.services.ServicesDTO;
import com.example.homeworkbackend.services.ServicesEntity;
import com.example.homeworkbackend.services.ServicesMapper;
import com.example.homeworkbackend.services.ServicesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final RandomCustomerData randomCustomerData;
    private final CustomerMapper customerMapper;

    private final ServicesRepository servicesRepository;
    private final RandomServicesData randomServicesData;
    private final ServicesMapper servicesMapper;

    public Bootstrap(CustomerRepository customerRepository,
                     RandomCustomerData randomCustomerData,
                     CustomerMapper customerMapper,
                     ServicesRepository servicesRepository,
                     RandomServicesData randomServicesData,
                     ServicesMapper servicesMapper) {
        this.customerRepository = customerRepository;
        this.randomCustomerData = randomCustomerData;
        this.customerMapper = customerMapper;
        this.servicesRepository = servicesRepository;
        this.randomServicesData = randomServicesData;
        this.servicesMapper = servicesMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCustomers();
        loadServices();
    }

    private void loadCustomers() {
        if (customerRepository.findAll().isEmpty()) {
            for (int i = 1; i <= 50; i++) {
                CustomerDTO dto = randomCustomerData.generateCustomerData();
                CustomerEntity entity = customerMapper.dtoToEntity(dto);
                entity.setId((long) i);
                customerRepository.save(entity);
            }
        }
    }

    private void loadServices() {
        if (servicesRepository.findAll().isEmpty()) {
            for (int i=1; i<= 10; i++){
                ServicesDTO dto = randomServicesData.generateServicesData();
                ServicesEntity entity = servicesMapper.dtoToEntity(dto);
                entity.setId((long) i);
                servicesRepository.save(entity);
            }
        }
    }

}
