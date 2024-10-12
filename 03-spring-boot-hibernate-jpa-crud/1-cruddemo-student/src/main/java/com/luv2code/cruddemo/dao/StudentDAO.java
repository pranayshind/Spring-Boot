package com.luv2code.cruddemo.dao;

import java.util.List;

import com.luv2code.cruddemo.entity.Student;

public interface StudentDAO {


    void save(Student theStudent);  //to create


    Student findById(Integer id);   //to read

    List<Student> findAll(); //to query

    List<Student> findByLastName(String lastName); // query to find by lasst name

    void update(Student theStudent);  //to update

    void delete(Integer id);//to delete

    int deleteAll();
}
