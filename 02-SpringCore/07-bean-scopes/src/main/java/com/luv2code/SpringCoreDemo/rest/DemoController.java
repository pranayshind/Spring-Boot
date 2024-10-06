package com.luv2code.SpringCoreDemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.SpringCoreDemo.common.Coach;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DemoController {

    

    //define private field for dependency injection
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(
                        @Qualifier("cricketCoach") Coach theCoach,
                        @Qualifier("cricketCoach") Coach theanotherCoach){
        System.out.println("In Constructor: "+getClass().getSimpleName());
        myCoach=theCoach;
        anotherCoach=theanotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkOut();
    }

    @GetMapping("/check")
    public String check() {
        return " Comparing beans: myCoach == anotherCoach. " + (myCoach==anotherCoach);
    }
    
    

}
