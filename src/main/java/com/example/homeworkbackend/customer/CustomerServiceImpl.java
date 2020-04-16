package com.example.homeworkbackend.customer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public CustomerServiceImpl(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<CustomerDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::entityToDTO)
                .collect(Collectors.toList());
    }
}
