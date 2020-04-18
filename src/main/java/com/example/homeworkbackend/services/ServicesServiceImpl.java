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
    public ServicesDTO createService(Long customerId, ServicesDTO servicesDTO) {
        if (!customerRepository.existsById(customerId)) {
            log.error("Customer with id: " + customerId + " not found.");
            return null;
        } else {
            CustomerEntity customerEntity = customerRepository.findById(customerId).get();
            ServicesEntity servicesEntity = servicesMapper.dtoToEntity(servicesDTO);
            servicesEntity.setCustomer(customerEntity);
            ServicesEntity saved = servicesRepository.save(servicesEntity);
            return servicesMapper.entityToDTO(saved);
        }

    }

    @Override
    public List<ServicesDTO> getServicesByCustomerId(Long customerId) {
        // TODO replace with findByCustomerID in repository...
        if (!customerRepository.existsById(customerId)) {
            log.error("Customer with id: " + customerId + " not found.");
            return null;
        } else {
            List<ServicesDTO> servicesDTOS = servicesRepository.findAll()
                    .stream()
                    .filter(servicesEntity -> servicesEntity.getCustomer() != null && servicesEntity.getCustomer().getId().equals(customerId))
                    .map(servicesMapper::entityToDTO)
                    .collect(Collectors.toList());

            return servicesDTOS;
        }
    }

    @Override
    public List<ServicesDTO> findAll() {
        return servicesRepository.findAll()
                .stream()
                .map(servicesMapper::entityToDTO)
                .collect(Collectors.toList());
    }
}
