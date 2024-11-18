package com.pranay.mvc.Dropdown.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pranay.mvc.Dropdown.model.Student;

@Controller
public class StudentController {

    @GetMapping("/showForm")
    public String showForm(Model m1){

        //create student object
        Student s1 = new Student();

        //add student object to model
        m1.addAttribute("student", s1);

        return "Student-Form";
        
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student s1){
        System.out.println(s1.getFirstName()+" "+s1.getLastName());
        return "Student-confirm";
    }

}
