package com.wings.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wings.jwt.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    User findByUserName(String userName);

}
