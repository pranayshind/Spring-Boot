package com.eazyBytes.jwtProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eazyBytes.jwtProject.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    

}
