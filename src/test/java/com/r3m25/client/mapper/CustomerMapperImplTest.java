package com.r3m25.client.mapper;

import com.r3m25.client.client.domain.User;
import com.r3m25.client.domain.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.r3m25.client.dummies.user.UserDummy.userDummy;
import static com.r3m25.client.dummies.user.UserDummy.userNullDummy;
import static com.r3m25.client.utilts.AssertUtils.assertDataCustomerWithDataUser;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
class CustomerMapperImplTest {

    @InjectMocks
    private CustomerMapperImpl customerMapperImpl;

    @Test
    public void shouldReturnNullWhenMapperWhitAUserNull() {
        User userNullDummy = userNullDummy();
        Customer customer = customerMapperImpl.userClientToCustomer(userNullDummy);
        assertNull(customer);
    }

    @Test
    public void shouldReturnCustomerWhenMapperFromUser() {
        Customer customer = customerMapperImpl.userClientToCustomer(userDummy());
        assertDataCustomerWithDataUser(customer, userDummy());
    }
}