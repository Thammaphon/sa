package com.sut.sa.cpe.controller;

import com.sut.sa.cpe.repository.UserRepository;
import com.sut.sa.cpe.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
    @Autowired
    private final UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/Users")
    public Collection<User> User() {
        return userRepository.findAll().stream().collect(Collectors.toList());
    }
}
