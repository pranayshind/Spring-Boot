package com.luv2code.SpringCoreDemo.common;


//here we are not using @componetmt purposefully to demontsrate bean method
public class SwimCoach implements Coach {

    public SwimCoach(){
        System.out.println("In constructor: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut() {
        // TODO Auto-generated method stub
        return "Swim 100 meteres as warmup";
    }

}
