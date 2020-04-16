package com.example.homeworkbackend.generator.customer;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomCityName {

    private static final List<String> CITIES = List.of(
            "Budapest", "London", "Paris", "New York", "Miami", "Debrecen");

    public static String genarateCity() {
        return CITIES.get(ThreadLocalRandom.current().nextInt(0, CITIES.size()-1));
    }
}
