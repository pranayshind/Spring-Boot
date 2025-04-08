package com.wings.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wings.jwt.entity.User;
import com.wings.jwt.repository.UserRepository;
import com.wings.jwt.service.UserService;


@RestController
public class UserController{

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user ){
        return userService.register(user);

    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return userService.verify(user);
    }
    
}
