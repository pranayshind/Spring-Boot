package com.luv2code.SpringCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    @Override
    public String getDailyWorkOut() {
        // TODO Auto-generated method stub
        return "Run a hard 5KM";
    }

}
