package com.example.homeworkbackend.sites;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SiteDTO {

    private Long id;

    private Integer zip;

    private String city;

    private String street;

    private Integer houseNumber;

}
