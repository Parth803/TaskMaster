package com.example.taskmaster.service;

import com.example.taskmaster.api.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    // connect to DB

    public Optional<User> getUser(Integer id) {
        Optional<User> user = Optional.empty();
        // retrieve user from the db

        return user;
    }

    public User createUser(User user) {
        return null;
    }
}
