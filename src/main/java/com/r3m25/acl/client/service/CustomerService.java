package com.r3m25.acl.client.service;

import com.r3m25.acl.client.adapter.CustomerAdapter;
import com.r3m25.acl.client.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerAdapter customerAdapter;

    /**
     * Inti Customer Service.
     * @param customerAdapter Customer Adapter.
     */
    public CustomerService(CustomerAdapter customerAdapter) {
        this.customerAdapter = customerAdapter;
    }

    public Customer findCustomerById(String customerId) {
        return customerAdapter.getCustomerById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerAdapter.getAllCustomers();
    }
}
