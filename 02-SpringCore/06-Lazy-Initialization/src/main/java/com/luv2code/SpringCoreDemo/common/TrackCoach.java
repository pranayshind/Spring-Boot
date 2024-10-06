package com.luv2code.SpringCoreDemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy                                          //since we are not injecting trackcoach by giving @Lazy hence it is not initialized
public class TrackCoach implements Coach {
    public TrackCoach(){
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkOut() {
        // TODO Auto-generated method stub
        return "Run a hard 5KM";
    }

}
