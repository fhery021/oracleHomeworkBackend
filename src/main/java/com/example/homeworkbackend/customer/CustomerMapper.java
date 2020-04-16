package com.example.homeworkbackend.customer;

import com.example.homeworkbackend.common.RequestResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper implements RequestResponseMapper<CustomerEntity, CustomerRequest, CustomerResponse> {

    @Override
    public CustomerResponse entityToResponse(CustomerEntity entity) {
        if (entity == null) {
            return null;
        }
        return CustomerResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .cityName(entity.getCityName())
                .phoneNumber(entity.getPhoneNumber())
                .emailAddress(entity.getEmailAddress())
                .netIncome(entity.getNetIncome())
                .build();
    }

    @Override
    public CustomerEntity requestToEntity(CustomerRequest request) {
        if (request == null) {
            return null;
        }
        return CustomerEntity.builder()
                .name(request.getName())
                .cityName(request.getCityName())
                .phoneNumber(request.getPhoneNumber())
                .emailAddress(request.getEmailAddress())
                .netIncome(request.getNetIncome())
                .build();
    }

}
