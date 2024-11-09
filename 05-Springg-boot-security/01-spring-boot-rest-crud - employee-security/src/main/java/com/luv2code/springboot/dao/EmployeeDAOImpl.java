package com.luv2code.springboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {


    //define field for entity manager
    private EntityManager entityManager;




    //setup constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create a query


        // TypedQuery<Employee> theQuery: Declares a TypedQuery specifically for Employee entities, ensuring type safety (returning only Employee objects).
        // entityManager.createQuery("from Employee", Employee.class);:
        // The createQuery method of EntityManager creates a query to retrieve all Employee entities.
        // "from Employee" is a JPQL (Java Persistence Query Language) statement, which instructs JPA to select all rows from the Employee table.
        // Employee.class: Specifies that the query should return Employee objects, making it a typed query.
        
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //execute query and get result list

        // theQuery.getResultList();: Executes the query and returns the results as a list of Employee objects.
        // This result list is then assigned to the employees variable, which will contain all records of Employee entities from the database.
        List<Employee> employees = theQuery.getResultList();

        //retutn the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        // TODO Auto-generated method stub

        //get employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //return employee
        return theEmployee;
       
    }

    @Override
    public Employee save(Employee theEmployee) {
        // TODO Auto-generated method stub
        
        //save or update employee
        Employee dbEmployee=entityManager.merge(theEmployee);  //if id==0 then save/insert else update

        return dbEmployee;
    }

    @Override
    public void deleteByID(int theId) {
        // TODO Auto-generated method stub
        Employee theEmployee=entityManager.find(Employee.class, theId);

        entityManager.remove(theEmployee);
    }

}
