package com.pranay.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
   //controller method to show initial form
    @RequestMapping("/showForm")
        public String showForm(){
            return "helloWorld-form";  //i.e helloworld-form.html
        }
    
    //need a controller to process html form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }
     
}
