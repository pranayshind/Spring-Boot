package com.pranay.security.springSec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pranay.security.springSec.Repo.UserRepo;
import com.pranay.security.springSec.model.UserPrincipal;
import com.pranay.security.springSec.model.Users;

@Service
public class MyUserDeatailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Users users = userRepo.findByUserName(username);

        
        if(users==null){
            System.out.println("User not found");
            throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
        }

        return new UserPrincipal(users);
        
    }

}
