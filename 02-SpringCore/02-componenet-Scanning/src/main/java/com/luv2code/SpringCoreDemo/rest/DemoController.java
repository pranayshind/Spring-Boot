package com.luv2code.SpringCoreDemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.SpringCoreDemo.common.Coach;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DemoController {

    //define private field for dependency injection
    private Coach myCoach;

    @Autowired    //tells spring to inject dependency. if you have one constructor then autowired is optional
    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkOut();
    }
    

}
