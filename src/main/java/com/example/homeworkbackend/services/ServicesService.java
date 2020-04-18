package com.example.homeworkbackend.services;

import java.util.List;

public interface ServicesService {

    List<ServicesDTO> geServicesByCustomerId(Long customerId);

    ServicesDTO applyCustomer(Long customerId, Long serviceId);

    List<ServicesDTO> findAll();
}
