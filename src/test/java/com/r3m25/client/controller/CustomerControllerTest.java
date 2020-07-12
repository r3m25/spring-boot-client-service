package com.r3m25.client.controller;

import com.r3m25.client.domain.Customer;
import com.r3m25.client.dummies.customer.CustomerDummy;
import com.r3m25.client.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.r3m25.client.dummies.customer.CustomerDummy.customerDummy;
import static com.r3m25.client.dummies.customer.CustomerDummy.customerListDummy;
import static com.r3m25.client.utilts.AssertUtils.assertNotNullCustomer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    private final static String CUSTOMER_ID = "";

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @Test
    public void shouldReturnCustomerResponseAndStatusOk() {
        when(customerService.findCustomerById(CUSTOMER_ID)).thenReturn(customerDummy());
        ResponseEntity<Customer> customer = customerController.findCustomerById(CUSTOMER_ID);

        assertNotNull(customer);
        assertEquals(HttpStatus.OK, customer.getStatusCode());
        assertNotNull(customer.getBody());
        assertNotNullCustomer(customer.getBody());
    }

    @Test
    public void shouldReturnListCustomerResponseAndStatusOk() {
        when(customerService.getCustomers()).thenReturn(customerListDummy());
        ResponseEntity<List<Customer>> customerList = customerController.getAllCustomers();
        assertNotNull(customerList);
        assertEquals(HttpStatus.OK, customerList.getStatusCode());
        assertNotNull(customerList.getBody());
        customerList.getBody().forEach(customer -> assertNotNullCustomer(customer));
    }

}