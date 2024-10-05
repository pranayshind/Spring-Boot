package com.luv2code.SpringCoreDemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component           //componenet annotation marlks the class as a Spring Bean
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkOut() {
        
       return "Practice fast Bowling for 15 minutes";
    }
    
 
}
