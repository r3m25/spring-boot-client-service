package com.r3m25.client.service;

import com.r3m25.client.adapter.CustomerAdapter;
import com.r3m25.client.domain.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.r3m25.client.dummies.customer.CustomerDummy.customerDummy;
import static com.r3m25.client.dummies.customer.CustomerDummy.customerListDummy;
import static com.r3m25.client.utilts.AssertUtils.assertNotNullCustomer;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerAdapter customerAdapter;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void shouldReturnCustomerWhenFindById() {
        String customerId = "1234";
        when(customerAdapter.getCustomerById(customerId)).thenReturn(customerDummy());
        Customer customerById = customerService.findCustomerById(customerId);
        assertNotNull(customerById);
    }

    @Test
    public void shouldReturnCustomerListWhenGetAll() {
        when(customerAdapter.getCustomers()).thenReturn(customerListDummy());
        List<Customer> customerList = customerService.getCustomers();
        assertNotNull(customerList);
        assertFalse(customerList.isEmpty());
        customerList.forEach(customer -> assertNotNullCustomer(customer));
    }

}