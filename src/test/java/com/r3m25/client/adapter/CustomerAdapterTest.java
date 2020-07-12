package com.r3m25.client.adapter;

import com.r3m25.client.client.UserClient;
import com.r3m25.client.client.domain.User;
import com.r3m25.client.domain.Customer;
import com.r3m25.client.exception.NotFoundException;
import com.r3m25.client.mapper.CustomerMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.r3m25.client.dummies.customer.CustomerDummy.customerDummy;
import static com.r3m25.client.dummies.user.UserDummy.*;
import static com.r3m25.client.utilts.AssertUtils.assertDataCustomerWithDataUser;
import static com.r3m25.client.utilts.AssertUtils.assertExpectedUser;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerAdapterTest {

    private static String CUSTOMER_ID = "1";

    @Mock
    private UserClient userClient;

    @Mock
    private CustomerMapper customerMapper;

    @InjectMocks
    private CustomerAdapter customerAdapter;

    @Captor
    private ArgumentCaptor<String> customerIdCaptor;

    @Captor
    private ArgumentCaptor<User> userCaptor;

    @Test
    public void shouldReturnCustomerById() {

        when(userClient.getUserById(customerIdCaptor.capture()))
                .thenReturn(userDummy());

        when(customerMapper.userClientToCustomer(userCaptor.capture()))
                .thenReturn(customerDummy());

        Customer customer = customerAdapter.getCustomerById(CUSTOMER_ID);

        assertDataCustomerWithDataUser(customer, userCaptor.getValue());
        assertEquals(CUSTOMER_ID, customerIdCaptor.getValue());
        assertExpectedUser(userDummy(), userCaptor.getValue());

    }

    @Test
    public void shouldReturnCustomers() {

        when(userClient.getUsers()).thenReturn(userListDummy());
        List<Customer> customers = customerAdapter.getCustomers();
        assertNotNull(customers);
    }

    @Test
    public void shouldReturnNotFoundExceptionCustomersWhenUserListIsNull() {

        when(userClient.getUsers()).thenReturn(userListNullDummy());

        assertThrows(NotFoundException.class, () -> {
            customerAdapter.getCustomers();
        });
    }

}