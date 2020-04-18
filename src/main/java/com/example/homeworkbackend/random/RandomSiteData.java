package com.example.homeworkbackend.random;

import com.example.homeworkbackend.sites.SiteDTO;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class RandomSiteData {

    public SiteDTO generateSiteData() {
        return SiteDTO.builder()
                .zip(ThreadLocalRandom.current().nextInt(1000, 10000))
                .city(RandomCityName.genarateCity())
                .street(RandomStreetName.generateStreetName())
                .houseNumber(ThreadLocalRandom.current().nextInt(1, 100))
                .build();
    }

}
