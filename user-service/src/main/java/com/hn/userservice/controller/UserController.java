package com.hn.userservice.controller;

import com.hn.userservice.model.User;
import com.hn.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/test")
    public void test(){
        userService.showTest();
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.registerUser(user);
    }

    @GetMapping("/")
    public User getUserByUserName(@RequestParam String username, @RequestHeader(required = false) String loggedInUser){
        System.out.println("loggedInUser : " + loggedInUser);
        return userService.getUserByUsername(username);
    }

}
