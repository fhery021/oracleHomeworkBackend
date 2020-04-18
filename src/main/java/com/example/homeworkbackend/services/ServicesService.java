package com.example.homeworkbackend.services;

import java.util.List;

public interface ServicesService {

    List<ServicesDTO> getServicesByCustomerId(Long customerId);

    ServicesDTO createService(Long customerId, ServicesDTO servicesDTO);

    List<ServicesDTO> findAll();
}
