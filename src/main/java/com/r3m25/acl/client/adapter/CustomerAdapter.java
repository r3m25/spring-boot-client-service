package com.r3m25.acl.client.adapter;

import com.r3m25.acl.client.client.UserClient;
import com.r3m25.acl.client.domain.Customer;
import com.r3m25.acl.client.mapper.CustomerMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerAdapter {

    private final UserClient userClient;
    private final CustomerMapper customerMapper;

    /**
     * Init Customer Adapter.
     * @param userClient User Client.
     * @param customerMapper Customer Mapper.
     */
    public CustomerAdapter(UserClient userClient, CustomerMapper customerMapper) {
        this.userClient = userClient;
        this.customerMapper = customerMapper;
    }

    public Customer getCustomerById(String id) {
        return null;
    }

    public List<Customer> getAllCustomers() {
        return null;
    }

}
