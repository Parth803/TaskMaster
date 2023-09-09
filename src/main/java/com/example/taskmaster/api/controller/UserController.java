package com.example.taskmaster.api.controller;

import com.example.taskmaster.api.model.User;
import com.example.taskmaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ResponseEntity<Object> getUser(@RequestParam Integer id) {
        Optional<User> user = userService.getUser(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    @PostMapping("/user")
    public ResponseEntity<Object> postUser(@RequestBody User newUser) {
        User createdUser = userService.createUser(newUser);
        if (createdUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User creation failed");
        }
    }

    @DeleteMapping("/user")
    public ResponseEntity<Object> deleteUser(@RequestParam Integer id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return ResponseEntity.ok("User deleted");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User deletion failed");
        }
    }

    @PutMapping("/user")
    public ResponseEntity<Object> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        if (updatedUser != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User update failed");
        }
    }
}
