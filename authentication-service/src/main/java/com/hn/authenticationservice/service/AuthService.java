package com.hn.authenticationservice.service;

import com.hn.authenticationservice.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    JwtService jwtService;
    private final WebClient.Builder webClientBuilder;

    public UserResponse getUserByUsername(String username) {
        return webClientBuilder.build().get()
                .uri("http://user-service/api/user/",
                        uriBuilder -> uriBuilder.queryParam("username", username).build())
                .retrieve()
                .bodyToMono(UserResponse.class)
                .block();
    }

    public String generateToken(String username){
        return jwtService.createToken(username);
    }

    public String validateToken(String token){
        return jwtService.decodeToken(token);
    }
}
