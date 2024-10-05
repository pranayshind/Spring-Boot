package com.luv2code.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DemoController {

    //define private field for dependency injection
    private Coach coach;

    @Autowired    //tells spring to inject dependency. if you have one constructor then autowired is optional
    public DemoController(Coach coach){
        this.coach=coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkOut();
    }
    

}
