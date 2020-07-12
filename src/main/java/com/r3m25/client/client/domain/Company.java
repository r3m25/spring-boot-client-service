package com.r3m25.client.client.domain;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private String name;
    private String catchPhrase;
    private String bs;
}
