package com.example.homeworkbackend.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {

//    •   Customer name
//•       Customer Legal address city name
//•       Customer phone number
//•       Customer e-mail address
//•       Customer net income


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cityName;

    private String phoneNumber;

    private String emailAddress;

    private Long netIncome;

}
