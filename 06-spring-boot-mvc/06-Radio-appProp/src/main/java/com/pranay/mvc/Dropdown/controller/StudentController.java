package com.pranay.mvc.Dropdown.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pranay.mvc.Dropdown.model.Student;

@Controller
public class StudentController {

    @Value("${countries}")//same name as app.properties file
    private List<String> countries;   //injection

    @Value("${Languages}")//same name as app.properties file
    private List<String> languages;  //injection

    @GetMapping("/showForm")
    public String showForm(Model m1){

        //create student object
        Student s1 = new Student();

        //add student object to model
        m1.addAttribute("student", s1);

         // add the list of countries to the model
        m1.addAttribute("country", countries);

        // add the list of Languages to the model
        m1.addAttribute("lang",languages );

        

        return "Student-Form";
        
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student s1){
        //System.out.println(s1.getFirstName()+" "+s1.getLastName());
        return "Student-confirm";
    }

}
