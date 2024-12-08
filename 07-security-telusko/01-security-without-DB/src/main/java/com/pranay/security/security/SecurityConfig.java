package com.pranay.security.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{



        return http
        .csrf(customizer-> customizer.disable())
        .authorizeHttpRequests(request -> request.anyRequest().authenticated())
        .httpBasic(Customizer.withDefaults())
        .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .build();
    }

    //InMemoryUserDetails indirectly implements UserDetailsManager
    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user1 = User
                            .withDefaultPasswordEncoder()
                            .username("Panya")
                            .password("Pass@123")
                            .roles("User")
                            .build();
        UserDetails user2 = User
                            .withDefaultPasswordEncoder()
                            .username("ROshan")
                            .password("Pass@1234")
                            .roles("User")
                            .build();
                            
                            

        return new InMemoryUserDetailsManager(user1,user2);

    }

}
