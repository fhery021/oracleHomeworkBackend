package com.example.homeworkbackend.services;

import com.example.homeworkbackend.customer.CustomerDTO;
import com.example.homeworkbackend.customer.CustomerEntity;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
public class ServicesDTO {

    private Long id;

    private ServicesType type;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDate;

    private String description;

//    private CustomerDTO customerDTO;
}
