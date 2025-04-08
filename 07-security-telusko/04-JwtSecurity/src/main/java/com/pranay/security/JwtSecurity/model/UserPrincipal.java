package com.pranay.security.JwtSecurity.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {

    private Users users;

    public UserPrincipal(Users users) {
        //TODO Auto-generated constructor stub
        this.users=users;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return users.getUsername();
    }

}
