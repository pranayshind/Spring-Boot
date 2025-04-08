package com.wings.jwt.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.wings.jwt.entity.User;
import com.wings.jwt.repository.UserRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByUserName(username);
       if(Objects.isNull(user)){
        System.out.println("User not availiable");
        throw new UsernameNotFoundException("User not found");
       }
    return new CustomUserDetails(user);
    }
    
}