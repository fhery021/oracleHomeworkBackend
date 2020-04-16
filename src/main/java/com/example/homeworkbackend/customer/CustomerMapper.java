package com.example.homeworkbackend.customer;

import com.example.homeworkbackend.common.DTOMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper implements DTOMapper<CustomerEntity, CustomerDTO> {

    @Override
    public CustomerEntity dtoToEntity(CustomerDTO dto) {
        if (dto == null) {
            return null;
        }
        return CustomerEntity.builder()
                .name(dto.getName())
                .cityName(dto.getCityName())
                .phoneNumber(dto.getPhoneNumber())
                .emailAddress(dto.getEmailAddress())
                .netIncome(dto.getNetIncome())
                .build();
    }

    @Override
    public CustomerDTO entityToDTO(CustomerEntity entity) {
        if (entity == null) {
            return null;
        }
        return CustomerDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .cityName(entity.getCityName())
                .phoneNumber(entity.getPhoneNumber())
                .emailAddress(entity.getEmailAddress())
                .netIncome(entity.getNetIncome())
                .build();
    }
}
