package com.luv2code.SpringCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkOut() {
        // TODO Auto-generated method stub
        return "Practice ypur backhand volley";
    }

}
