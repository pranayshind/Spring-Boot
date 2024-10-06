package com.luv2code.SpringCoreDemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.SpringCoreDemo.common.Coach;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class DemoController {

    

    //define private field for dependency injection
    private Coach myCoach;
    

    @Autowired
    public DemoController(
                        @Qualifier("cricketCoach") Coach theCoach
                       ){
        System.out.println("In Constructor: "+getClass().getSimpleName());
        myCoach=theCoach;
        
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkOut();
    }

    
    
    

}
