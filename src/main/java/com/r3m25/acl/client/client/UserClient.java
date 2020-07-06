package com.r3m25.acl.client.client;

import com.r3m25.acl.client.client.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-client", url = "${jsonplaceholder.url}")
public interface UserClient {

    @GetMapping("/users/{userId}")
    User getUserById(@PathVariable String userId);

    @GetMapping("/users")
    List<User> getAllUser();

}
