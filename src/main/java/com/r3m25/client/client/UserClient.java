package com.r3m25.client.client;

import com.r3m25.client.client.configuration.FeignClientConfiguration;
import com.r3m25.client.client.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "user-client",
        url = "${jsonplaceholder.url}",
        configuration = FeignClientConfiguration.class)
public interface UserClient {

    @GetMapping("/users/{userId}")
    User getUserById(@PathVariable String userId);

    @GetMapping("/users")
    List<User> getUsers();

}
