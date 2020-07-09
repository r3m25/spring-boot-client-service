package com.r3m25.client.client;

import com.r3m25.client.client.domain.User;
import com.r3m25.client.configuration.IntegrationTestBase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class UserClientIntegrationTest extends IntegrationTestBase {

    @Autowired
    private UserClient userClient;

    @Test
    public void shouldReturnUserList() {

        List<User> allUser = userClient.getAllUser();
        assertNotNull(allUser);
        assertFalse(allUser.isEmpty());
        allUser.forEach(user -> assertNotNull(user));
    }
}