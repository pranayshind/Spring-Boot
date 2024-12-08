package com.pranay.security.controller;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pranay.security.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

    ArrayList<Student> s1 = new ArrayList<>(
            List.of(
                    new Student(1, "Panay", "sprany@gmail.com"),
                    new Student(2, "roshan", "roshan@gmail.com")
                    ));

    @GetMapping("/students")
    public List<Student> getStudents(){
        return s1;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student stu){
        s1.add(stu);
        return stu;
    }

    //to return csrf token
    @RequestMapping("/csrf")
    public CsrfToken getToken(HttpServletRequest req){
        return (CsrfToken) req.getAttribute("_csrf");
    }

}
