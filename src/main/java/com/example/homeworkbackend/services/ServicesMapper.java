package com.example.homeworkbackend.services;

import com.example.homeworkbackend.common.DTOMapper;
import com.example.homeworkbackend.customer.CustomerMapper;
import org.springframework.stereotype.Component;

@Component
public class ServicesMapper implements DTOMapper<ServicesEntity, ServicesDTO> {

    private final CustomerMapper customerMapper;

    public ServicesMapper(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    public ServicesEntity dtoToEntity(ServicesDTO dto) {
        if (dto == null){
            return null;
        }
        return ServicesEntity.builder()
                .type(dto.getType())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .description(dto.getDescription())
//                .customer(customerMapper.dtoToEntity(dto.getCustomerDTO()))
                .build();
    }

    @Override
    public ServicesDTO entityToDTO(ServicesEntity entity) {
        if (entity == null) {
            return null;
        }
        return ServicesDTO.builder()
                .id(entity.getId())
                .type(entity.getType())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .description(entity.getDescription())
//                .customerDTO(customerMapper.entityToDTO(entity.getCustomer()))
                .build();
    }
}
