package com.wings.jwt.controller;

import java.util.Objects;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wings.jwt.entity.User;
import com.wings.jwt.repository.UserRepository;
import com.wings.jwt.service.UserService;

@RestController
public class UserContoller {

    private final UserRepository userRepository;
    private final UserService userService;


    public UserContoller(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        // return userRepository.save(user);
        return userService.register(user);
    
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
       
    //    var u = userRepository.findByUserName(user.getUserName());
    //    if(!Objects.isNull(u))
    //        return "success";
    //    return "failure";

        return userService.verify(user);
    }

}
