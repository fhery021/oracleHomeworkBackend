package com.example.homeworkbackend.customer;

import java.util.List;

public interface CustomerService {

    List<CustomerResponse> findAll();

    CustomerResponse findById(Long customerId);

}
