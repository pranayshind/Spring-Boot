package com.luv2code.SpringCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    public BaseballCoach(){
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkOut() {
        // TODO Auto-generated method stub
        return "Sepnd 30 minutes on batting parctice";
    }
   

  
    
}
