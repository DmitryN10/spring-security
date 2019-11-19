package com.in28minutes.springboot.controller;

import com.in28minutes.springboot.jpa.UserRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private  final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
