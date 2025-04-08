package com.wings.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

//   @Autowired
//   JwtAuthenticationFiler jwtAuthenticationFiler;

  @Autowired
  UserDetailsService userDetailsService;

   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
    httpSecurity
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(request -> request
                               .requestMatchers("register","login").permitAll()
                               .anyRequest().authenticated()
                               )
        .httpBasic(Customizer.withDefaults());
        // .addFilterBefore(jwtAuthenticationFiler, UsernamePasswordAuthenticationFilter.class);
    
    return httpSecurity.build();
   }

   @Bean
   public BCryptPasswordEncoder bCryptPasswordEncoder(){
    return new BCryptPasswordEncoder(14);
   }

   @Bean
   public AuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(userDetailsService);
    provider.setPasswordEncoder(bCryptPasswordEncoder());

    return provider;
   }

   @Bean
   public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
    return configuration.getAuthenticationManager();
   }
}


