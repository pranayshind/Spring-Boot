package com.luv2code.SpringCoreDemo.common;


import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component           //componenet annotation marlks the class as a Spring Bean


public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }

  
    
    
    @Override
    public String getDailyWorkOut() {
        
       return "Practice fast Bowling for 15 minutes";
    }
    
 
}