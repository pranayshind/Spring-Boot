package com.pranay.security.JwtSecurity.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pranay.security.JwtSecurity.model.Users;
import com.pranay.security.JwtSecurity.service.UserService;

//passwords => Alka=Alka@123 Ramesh=Ramesh@123

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public Users postUser(@RequestBody Users users){
        return userService.saveUser(users);
    }

    @PostMapping("/login")
    public String loginUSer(@RequestBody Users users){
        return userService.validate(users);
    }

}
