package com.pranay.security.JwtSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranay.security.JwtSecurity.model.Users;


public interface UserRepo extends JpaRepository<Users,Integer>{

    Users findByUsername(String username);

    


}
