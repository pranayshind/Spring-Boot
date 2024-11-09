package com.luv2code.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



// InMemoryUserDetailsManager => This method creates and returns an instance of InMemoryUserDetailsManager. This is an implementation of the UserDetailsService 
// interface that stores user details in memory (i.e., it is not persisted to a database or an external storage).

@Configuration
public class DemoSecurityConfig {

    // Three UserDetails objects are created using the User.builder() method:
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        
        UserDetails john = User.builder()
                    .username("john")
                    .password("{noop}test123")
                    .roles("Employee")
                    .build();
        
         UserDetails mary = User.builder()
                    .username("mary")
                    .password("{noop}test123")
                    .roles("Employee","Manager")
                    .build();

        UserDetails susan = User.builder()
                    .username("susan")
                    .password("{noop}test123")
                    .roles("Employee","Manager","Admin")
                    .build();
        
    return new InMemoryUserDetailsManager(john,mary,susan);
    //since we define users here then springboot will not use user/pass from application.properties file

    }


    //code for security based on roles
    
    //public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    //This method configures security for HTTP requests using the HttpSecurity object, which allows customization of web security in the application.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity  http) throws Exception{
        

        // http.authorizeHttpRequests(...)
        //This section defines authorization rules for HTTP requests based on the requested URL patterns and HTTP methods.

        
        http.authorizeHttpRequests(configurer ->
                configurer
                    .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("Employee")
                    .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("Employee")
                    .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("Manager")
                    .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("Manager")
                    .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("Admin")
        );

        //configurer.requestMatchers(...): Specifies which endpoints and HTTP methods should be secured and which roles are required to access them.

        //using http basic authentication
        http.httpBasic(Customizer.withDefaults());
        

        //disable csrf becuase it is not required for stateles rest Api thats use post put delete 
        http.csrf(csrf -> csrf.disable());

        return http.build();

    } 



    }


