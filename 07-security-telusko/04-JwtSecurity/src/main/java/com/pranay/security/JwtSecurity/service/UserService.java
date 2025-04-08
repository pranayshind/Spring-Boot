package com.pranay.security.JwtSecurity.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pranay.security.JwtSecurity.model.Users;
import com.pranay.security.JwtSecurity.repository.UserRepo;


@Service
public class UserService {

    @Autowired
    private UserRepo userrepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    
    public List<Users> getAllUsers(){
        
        return userrepo.findAll();

    }

    private BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
    public Users saveUser(Users users){
        users.setPassword(encoder.encode(users.getPassword()));
        userrepo.save(users);
        return users;
    }

    public String validate(Users users) {
        // TODO Auto-generated method stub
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
        if(authentication.isAuthenticated()){
            return "Success";
        }
        else{
            return "fail";
        }

        
    }

}
