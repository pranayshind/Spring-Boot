package com.luv2code.springcore;

import org.springframework.stereotype.Component;

@Component           //componenet annotation marlks the class as a Spring Bean
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkOut() {
        // TODO Auto-generated method stub
       return "Practice fast Bowling for 15 minutes";
    }
    
 
}
