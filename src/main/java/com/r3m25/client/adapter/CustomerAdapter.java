package com.r3m25.client.adapter;

import com.r3m25.client.client.UserClient;
import com.r3m25.client.configuration.anotation.Adapter;
import com.r3m25.client.domain.Customer;
import com.r3m25.client.exception.NotFoundException;
import com.r3m25.client.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Adapter
@RequiredArgsConstructor
public class CustomerAdapter {

    private final UserClient userClient;
    private final CustomerMapper customerMapper;

    public Customer getCustomerById(String id) {
        return customerMapper.userClientToCustomer(userClient.getUserById(id));
    }

    public List<Customer> getCustomers() {

        return Optional.ofNullable(userClient.getUsers())
                .orElseThrow(() ->
                        new NotFoundException(String.valueOf(NOT_FOUND),
                                "Empty List Customer.",
                                new Exception(NOT_FOUND.name())))
                                .stream()
                .map(customerMapper::userClientToCustomer).collect(Collectors.toList());
    }

}
