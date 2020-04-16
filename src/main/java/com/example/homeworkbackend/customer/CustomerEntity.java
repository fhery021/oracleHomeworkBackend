package com.example.homeworkbackend.customer;

import com.example.homeworkbackend.services.CustomerServiceEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cityName;

    private String phoneNumber;

    private String emailAddress;

    private Long netIncome;

    @OneToMany
    private List<CustomerServiceEntity> services;

}
