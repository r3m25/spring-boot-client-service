package com.r3m25.client.dummies.user;

import com.r3m25.client.client.domain.Address;
import com.r3m25.client.client.domain.Company;
import com.r3m25.client.client.domain.Geo;
import com.r3m25.client.client.domain.User;

import java.util.Arrays;
import java.util.List;

public final class UserDummy {

    private UserDummy() {
    }

    public static User userNullDummy() {
        return null;
    }

    public static List<User> userListNullDummy() {
        return null;
    }

    public static List<User> userListDummy() {
        return Arrays.asList(userDummy());
    }

    public static User userDummy() {
        return User.builder()
                .id(1234)
                .email("email@test.cl")
                .name("Ruben Morales")
                .phone("96582567")
                .username("r3m20")
                .website("www.apple.com")
                .address(addressDummy())
                .company(companyDummy())
                .build();
    }

    private static Company companyDummy() {
        return Company.builder()
                .bs("bsTest")
                .catchPhrase("catchPhraseTest")
                .name("Apple")
                .build();
    }

    private static Address addressDummy() {
        return Address.builder()
                .city("London")
                .geo(geoDummy())
                .street("Backer Street")
                .suite("SuitTest")
                .zipcode("123")
                .build();
    }

    private static Geo geoDummy() {
        return Geo.builder()
                .lat(-34.8879)
                .lng(-45.34534)
                .build();
    }
}
