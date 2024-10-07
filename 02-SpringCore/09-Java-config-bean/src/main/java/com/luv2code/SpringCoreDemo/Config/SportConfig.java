package com.luv2code.SpringCoreDemo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.luv2code.SpringCoreDemo.common.Coach;
import com.luv2code.SpringCoreDemo.common.SwimCoach;

@Configuration
public class SportConfig {

    @Bean("aquatic")  //aquatic is custom bean id
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
