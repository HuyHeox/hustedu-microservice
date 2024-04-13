package com.hn.authenticationservice.controller;

import com.google.protobuf.Descriptors;
import com.hn.authenticationservice.dto.UserResponse;
import com.hn.authenticationservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/grpc/user")
    public Map<Descriptors.FieldDescriptor, Object> getUserByUsernameGrpc(@RequestParam String username){
        return authService.getUserByUsernameGrpc(username);
    }
    @GetMapping("/grpc/users")
    public List<Map<Descriptors.FieldDescriptor, Object>> getAllUserGrpc() throws InterruptedException {
        return authService.getAllUserGrpc();
    }

    @GetMapping("/grpc/shortestName")
    public Map<String, Map<Descriptors.FieldDescriptor, Object>> getshortname() throws InterruptedException {
        return authService.getShortestName();
    }
    @GetMapping("/grpc/fullname")
    public List<Map<Descriptors.FieldDescriptor, Object>> updateUsernameByFullName() throws InterruptedException {
        return authService.updateUsernameByFullName();
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
