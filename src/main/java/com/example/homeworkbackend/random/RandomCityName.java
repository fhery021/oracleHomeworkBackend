package com.example.homeworkbackend.random;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomCityName {

    private static final List<String> CITIES = List.of(
            "Budapest", "London", "Paris", "New York", "Miami", "Debrecen", "Milan", "Rome");

    public static String genarateCity() {
        return CITIES.get(ThreadLocalRandom.current().nextInt(0, CITIES.size()));
    }
}
