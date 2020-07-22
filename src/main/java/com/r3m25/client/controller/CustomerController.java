package com.r3m25.client.controller;

import com.r3m25.client.configuration.anotation.Logger;
import com.r3m25.client.domain.Customer;
import com.r3m25.client.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @Logger
    @GetMapping(value = "/{customerId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> findCustomerById(@PathVariable String customerId) {
        return new ResponseEntity<>(customerService.findCustomerById(customerId),HttpStatus.OK);
    }

    @Logger
    @GetMapping(value = "/all", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getCustomers(),HttpStatus.OK);
    }

}
