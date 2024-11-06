package com.luv2code.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
    // Employee => Entity type
    // Integer => primary key

    
    //thats it no need to write code
}
