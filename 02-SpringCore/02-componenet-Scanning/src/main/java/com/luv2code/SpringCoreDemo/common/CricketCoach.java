package com.luv2code.SpringCoreDemo.common;

import org.springframework.stereotype.Component;

@Component           //componenet annotation marlks the class as a Spring Bean
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkOut() {
        
       return "Practice fast Bowling for 15 minutes";
    }
    
 
}
