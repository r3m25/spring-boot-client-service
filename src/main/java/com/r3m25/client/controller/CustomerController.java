package com.r3m25.client.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.r3m25.client.domain.Customer;
import com.r3m25.client.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/{customerId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> findCustomerById(@PathVariable String customerId) {
        return new ResponseEntity<>(customerService.findCustomerById(customerId),HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
    }

}
