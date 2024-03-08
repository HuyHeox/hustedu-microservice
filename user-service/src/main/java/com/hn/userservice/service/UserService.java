package com.hn.userservice.service;

import com.hn.userservice.exception.UserNotFoundException;
import com.hn.userservice.exception.UsernameAlreadyExistException;
import com.hn.userservice.model.User;
import com.hn.userservice.repository.impl.UserRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    UserRepositoryImpl userRepository;
    public void showTest(){
        System.out.println("test");
    }

    public User registerUser(User user){
        userRepository.getUserByUsername(user.getUsername()).ifPresent(e -> {
            throw new UsernameAlreadyExistException(user.getUsername());
        });
        return userRepository.save(user);
    }

    public User getUserByUsername(String username){
       return userRepository.getUserByUsername(username)
               .orElseThrow(() -> new UserNotFoundException(username));
    }

}
