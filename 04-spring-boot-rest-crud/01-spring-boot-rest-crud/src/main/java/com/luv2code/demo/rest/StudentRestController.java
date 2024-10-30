package com.luv2code.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.entity.Student;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct   //use to load data only once
    public void LoadData(){

        theStudents = new ArrayList<>();
        theStudents.add(new Student("Pranay", "Shinde"));
        theStudents.add(new Student("Om", "pawar"));
        theStudents.add(new Student("Nidhu", "Tembu"));

    }


    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    //define endpoint or "students/{studentID}"- return the student at index

    @GetMapping("/students/{studentId}")    //path variable
    public Student getStudent(@PathVariable int studentId){

        //check strudent id is valid or not
        if((studentId<0 || studentId>=theStudents.size())){
            throw new StudentNotFoundException("Student Id Not Found-"+ studentId);

        }
        return theStudents.get(studentId);
   
    }


    //above code is  use to load data only once it is efficeinet way comapre to following
    //define endpoint for "/Students"

    // @GetMapping("/students")
    // public List<Student> getStudents(){
    //     List<Student> theStudents = new ArrayList<>();
    //     theStudents.add(new Student("Pranay", "Shinde"));
    //     theStudents.add(new Student("Om", "pawar"));
    //     theStudents.add(new Student("Nidhu", "Tembu"));
    //     return theStudents ;
    // }
    


}
