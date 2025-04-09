package com.wings.jwt.service;

import java.util.Objects;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wings.jwt.entity.User;
import com.wings.jwt.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
            AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public User register(User user) {
      

        // encrypting the password form normal text to bcrypt
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        // saving user in db
        return userRepository.save(user);
    }

    public String verify(User user) {
        
    //authenticating username and password from db
       Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        
       
       //var u = userRepository.findByUserName(user.getUserName());
        //if (!Objects.isNull(u))
        if(authenticate.isAuthenticated())
            return jwtService.generateToken(user); //to generate token weneed to crate jwtservice
        return "failure";
    }

}
