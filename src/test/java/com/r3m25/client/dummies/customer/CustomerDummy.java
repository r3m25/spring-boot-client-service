package com.r3m25.client.dummies.customer;

import com.r3m25.client.domain.Customer;

import java.util.Collections;
import java.util.List;

public final class CustomerDummy {

    private CustomerDummy() {

    }

    public static List<Customer> customerListNullDummy() {
        return null;
    }

    public static List<Customer> customerListDummy() {
        return Collections.singletonList(customerDummy());
    }

    public static Customer customerDummy() {
        return Customer.builder()
                .customerId("1234")
                .address("Backer Street, London")
                .company("Apple")
                .email("email@test.cl")
                .phone("96582567")
                .username("r3m20")
                .name("Ruben Morales")
                .website("www.apple.com")
                .build();
    }

}
