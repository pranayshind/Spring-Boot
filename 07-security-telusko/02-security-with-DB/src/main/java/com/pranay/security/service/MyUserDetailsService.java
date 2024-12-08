package com.pranay.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pranay.security.model.UserPrincipal;
import com.pranay.security.model.Users;
import com.pranay.security.repo.UserRepo;
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub

        Users users = userRepo.findByUsername(username);
        if(users == null){
            System.out.println("user not found");
            throw new UsernameNotFoundException("user not found");
        }


        return new UserPrincipal(users);
    }

   

}
