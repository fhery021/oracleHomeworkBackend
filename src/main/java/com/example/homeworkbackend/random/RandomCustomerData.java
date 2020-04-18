package com.example.homeworkbackend.random;

import com.example.homeworkbackend.customer.CustomerDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class RandomCustomerData {

    public CustomerDTO generateCustomerData() {
        final String name = randomName();
        CustomerDTO customerDTO = CustomerDTO.builder()
                .name(name)
                .cityName(RandomCityName.genarateCity())
                .phoneNumber(randomPhoneNumber())
                .emailAddress(randomEmail(name))
                .netIncome(randomIncome())
                .build();
        return customerDTO;
    }

    private static final List<String> NAMES = List.of(
            "Noah", "Liam", "William", "Mason", "James", "Benjamin",
            "Jacob", "Michael", "Elijah", "Ethan", "Alexander", "Oliver",
            "Daniel", "Lucas", "Matthew", "Aiden", "Jackson", "Logan", "David",
            "Joseph", "Samuel", "Henry", "Owen", "Sebastian", "Gabriel", "Carter",

            "Emma", "Olivia", "Ava", "Sophia", "Isabella", "Mia", "Charlotte", "Abigail",
            "Emily", "Harper", "Amelia", "Evelyn", "Elizabeth", "Sofia", "Madison", "Avery",
            "Ella", "Scarlett", "Grace", "Chloe", "Victoria", "Riley", "Aria", "Lily", "Aubrey", "Zoey");


    private int randomIndexForNames() {
        return ThreadLocalRandom.current().nextInt(0, NAMES.size());
    }

    private String randomName() {
        final int index1 = randomIndexForNames();
        int index2 = randomIndexForNames();

        if (index1 == index2) {
            index2 = randomIndexForNames();
        }

        return new StringBuilder(NAMES.get(index1))
                .append(" ")
                .append(NAMES.get(index2))
                .toString();
    }

    private String randomPhoneNumber() {
        StringBuilder stringBuilder = new StringBuilder("+36");
        for (int i = 0; i < 9; i++) {
            stringBuilder.append(ThreadLocalRandom.current().nextInt(0, 9));
        }
        return stringBuilder.toString();
    }

    private String randomEmail(String name) {
        name = name.replaceAll("\\s", "_");
        name = name.toLowerCase();
        return new StringBuilder(name)
                .append("@")
                .append("gmail.com")
                .toString();
    }

    private Long randomIncome() {
        return ThreadLocalRandom.current().nextLong(500, 15000);
    }

}
