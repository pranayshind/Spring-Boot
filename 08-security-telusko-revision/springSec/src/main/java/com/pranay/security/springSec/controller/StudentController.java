package com.pranay.security.springSec.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pranay.security.springSec.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {






    private List<Student> students = new ArrayList<>(List.of(
        new Student(1,"Pranay",45),
        new Student(2,"Alka",50)


    ));


    @GetMapping("/student")
    public List<Student> getStudents(){
        return students;
    }


    //to get csrf toke a csrf is enable in springboot
    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student stu){
        students.add(stu);
        return stu;
    }

}
