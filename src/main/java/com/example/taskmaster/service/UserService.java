package com.example.taskmaster.service;

import com.example.taskmaster.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    // connect to DB
    @Autowired
    UserRepository userRepository;

    public Optional<User> getUser(Integer id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        // check if user already exists
        if (getUser(user.getId()).isPresent() || userRepository.findByEmail(user.getEmail()) != null) {
            return null;
        }
        return userRepository.save(user);
    }
    public boolean deleteUser(Integer id) {
        // check if user exists
        if (getUser(id).isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public User updateUser(User user) {
        // check if user exists
        if (getUser(user.getId()).isPresent()) {
            userRepository.save(user);
            return user;
        }
        return null;
    }
}
