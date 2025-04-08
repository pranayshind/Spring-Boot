package com.easyBytes.security.jwt.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class JwtSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults())
            .formLogin(Customizer.withDefaults())
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("hello","home").authenticated()
                .requestMatchers("help","info").permitAll()
            );

        return http.build();
    }
   @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.
                            withUsername("User").
                            password( "{noop}12345").
                            authorities("user").
                            build();

        UserDetails admin = User
                            .withUsername("Admin")
                            .password( "{bcrypt}$2a$12$NaxOcs4HUB3MxBsPBQqQjuoeFGioEV6NWnJDxfrX7vNQ6k8Whf2sG")
                            .authorities("user")
                            .build();
        
        return new InMemoryUserDetailsManager(user,admin);

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}






























