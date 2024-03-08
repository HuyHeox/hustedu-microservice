package com.hn.userservice.repository;

import com.hn.userservice.model.User;
import com.hn.userservice.repository.generic.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> getUserByUsername(String username);
}
