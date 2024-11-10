package com.luv2code.springboot.dao;
import java.util.List; 


import com.luv2code.springboot.entity.Employee;

public interface EmployeeDAO {

    //to return list of employees
    List<Employee> findAll();

    //to return single employee
    Employee findById(int theId);

    //to add/update an employee
    Employee save(Employee theEmployee);

    //to delete an employee
    void deleteByID(int theId);
    
}
