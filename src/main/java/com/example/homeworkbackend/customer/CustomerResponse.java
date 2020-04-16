package com.example.homeworkbackend.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponse {

    private Long id;

    private String name;

    private String cityName;

    private String phoneNumber;

    private String emailAddress;

    private Long netIncome;
}
