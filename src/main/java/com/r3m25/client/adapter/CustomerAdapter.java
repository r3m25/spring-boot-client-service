package com.r3m25.client.adapter;

import com.r3m25.client.client.UserClient;
import com.r3m25.client.configuration.anotation.Adapter;
import com.r3m25.client.domain.Customer;
import com.r3m25.client.mapper.CustomerMapper;

import java.util.List;

@Adapter
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
        return customerMapper.userClientToCustomer(userClient.getUserById(id));
    }

    public List<Customer> getAllCustomers() {
        return customerMapper.userClientListToCustomerList(userClient.getAllUser());
    }

}
