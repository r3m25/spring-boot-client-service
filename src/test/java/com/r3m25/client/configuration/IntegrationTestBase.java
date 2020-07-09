package com.r3m25.client.configuration;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.SingleRootFileSource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class IntegrationTestBase {

    private static WireMockServer wireMockServer;

    @BeforeAll
    static void setUp() {
        wireMockServer = new WireMockServer(
                wireMockConfig()
                        .port(8089)
                        .fileSource(new SingleRootFileSource("src/test/resources")));
        wireMockServer.start();
    }

    @AfterAll
    static void setDown(){
        wireMockServer.stop();
    }


}
