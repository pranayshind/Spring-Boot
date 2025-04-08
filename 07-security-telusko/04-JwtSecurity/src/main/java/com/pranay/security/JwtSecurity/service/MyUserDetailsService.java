package com.pranay.security.JwtSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pranay.security.JwtSecurity.model.UserPrincipal;
import com.pranay.security.JwtSecurity.model.Users;
import com.pranay.security.JwtSecurity.repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepo userrepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub

        Users users = userrepo.findByUsername(username);
        if(users==null){
            System.out.println("user not found");
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrincipal(users);
        
        
    }

}
