package com.r3m25.client.client;

import com.r3m25.client.configuration.IntegrationTestBase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class UserClientIntegrationTest extends IntegrationTestBase {

    @Autowired
    private UserClient userClient;

    @Test
    public void shouldReturnUserList() {
        userClient.getUsers()
                .stream()
                .peek(user -> assertNotNull(user))
                .peek(user -> assertTrue(Objects.nonNull(user)))
                .forEach(user -> assertNotNull(user));
    }
}