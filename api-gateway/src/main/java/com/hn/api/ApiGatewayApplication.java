package com.hn.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableAutoConfiguration
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ApiGatewayApplication {
    public static void main(String[] args){
        SpringApplication.run(ApiGatewayApplication.class,args);
    }
}
