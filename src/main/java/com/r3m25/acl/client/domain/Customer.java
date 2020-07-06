package com.r3m25.acl.client.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String customerId;
    private String name;
    private String username;
    private String email;
    private String address;
    private String phone;
    private String webSite;
    private String company;

}
