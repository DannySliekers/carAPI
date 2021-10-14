package com.avanshogeschool.API.controller;

import com.avanshogeschool.API.domain.User;
import com.avanshogeschool.API.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping Iterable<User> getAll() {
        return userRepository.findAll();
    }


}