package com.pranay.security.springSec.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranay.security.springSec.model.Users;

public interface UserRepo extends JpaRepository<Users,Integer> {

    Users findByUserName(String username);

}
