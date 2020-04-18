package com.example.homeworkbackend.sites;

import com.example.homeworkbackend.customer.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SiteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer zip;

    private String city;

    private String street;

    private Integer houseNumber;

    @ManyToOne
    @JoinColumn
    private CustomerEntity customer;
}
