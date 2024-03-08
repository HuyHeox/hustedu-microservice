package com.hn.authenticationservice.config;

import com.mongodb.AuthenticationMechanism;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfig {

    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }


//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
//        return config.getAuthenticationManager();
//    }
}
