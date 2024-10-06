package com.luv2code.SpringCoreDemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component           //componenet annotation marlks the class as a Spring Bean

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)    //prototype scope => New Object instance for each injection
public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkOut() {
        
       return "Practice fast Bowling for 15 minutes";
    }
    
 
}
