package com.hn.authenticationservice.controller;

import com.hn.authenticationservice.dto.UserResponse;
import com.hn.authenticationservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authentication")
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    AuthService authService;

//    @Autowired
//    AuthenticationManager authenticationManager;

    @GetMapping("/user")
    public UserResponse getUserByUsername(@RequestParam String username){
        return authService.getUserByUsername(username);
    }

    @PostMapping("/token")
    public String getToken(String username){
        return authService.generateToken(username);
    }

    @GetMapping("/validate")
    public String validateToken(String token){
        return authService.validateToken(token);
    }

}
