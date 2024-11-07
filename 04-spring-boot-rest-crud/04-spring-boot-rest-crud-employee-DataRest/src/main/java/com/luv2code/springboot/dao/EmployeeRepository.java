package com.luv2code.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.entity.Employee;


//@RepositoryRestResource(path="members") //to change path i.e to http://localhost:8080/members
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
    // Employee => Entity type
    // Integer => primary key

    
    //thats it no need to write code
}

