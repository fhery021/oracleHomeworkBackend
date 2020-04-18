package com.example.homeworkbackend.random;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomStreetName {

    private static final List<String> STREETS = List.of(
            "Main street", "This street", "That street", "Another street", "Ady Endre", "Tupac street");

    public static String generateStreetName(){
        return STREETS.get(ThreadLocalRandom.current().nextInt(0, STREETS.size()));
    }
}
