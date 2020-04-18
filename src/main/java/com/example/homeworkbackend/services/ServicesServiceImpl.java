package com.example.homeworkbackend.services;

import com.example.homeworkbackend.customer.CustomerEntity;
import com.example.homeworkbackend.customer.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class ServicesServiceImpl implements ServicesService {

    private final ServicesRepository servicesRepository;
    private final CustomerRepository customerRepository;

    private final ServicesMapper servicesMapper;

    public ServicesServiceImpl(ServicesRepository servicesRepository,
                               CustomerRepository customerRepository,
                               ServicesMapper servicesMapper) {
        this.servicesRepository = servicesRepository;
        this.customerRepository = customerRepository;
        this.servicesMapper = servicesMapper;
    }

    @Override
    public List<ServicesDTO> getServicesByCustomerId(Long customerId) {
        // TODO replace with findByCustomerID in repository...
        List<ServicesDTO> servicesDTOS = servicesRepository.findAll()
                .stream()
                .filter(servicesEntity -> servicesEntity.getCustomer() != null && servicesEntity.getCustomer().getId().equals(customerId))
                .map(servicesMapper::entityToDTO)
                .collect(Collectors.toList());

        return servicesDTOS;
    }

    @Override
    public ServicesDTO applyCustomer(Long customerId, Long serviceId) {

        Optional<CustomerEntity> customerEntityOpt = customerRepository.findById(customerId);
        if (!customerEntityOpt.isPresent()) {
            log.error("Customer with id: " + customerId + " not found.");
            return null;
        }

        Optional<ServicesEntity> servicesEntityOpt = servicesRepository.findById(serviceId);
        if(!servicesEntityOpt.isPresent()){
            log.error("Service with id: " + serviceId + "not found.");
            return null;
        }

        ServicesEntity entity = servicesEntityOpt.get();
        entity.setCustomer(customerEntityOpt.get());
        ServicesEntity saved = servicesRepository.save(entity);

        return servicesMapper.entityToDTO(saved);

    }

    @Override
    public List<ServicesDTO> findAll() {
        return servicesRepository.findAll()
                .stream()
                .map(servicesMapper::entityToDTO)
                .collect(Collectors.toList());
    }
}
