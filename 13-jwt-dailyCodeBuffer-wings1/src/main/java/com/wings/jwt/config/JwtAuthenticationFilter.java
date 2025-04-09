package com.wings.jwt.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.wings.jwt.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

  

    public JwtAuthenticationFilter(JwtService jwtService, UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

             final String authHeader = request.getHeader("Authorization");
             if(authHeader == null || !authHeader.startsWith(authHeader)){
                filterChain.doFilter(request, response);
                return;
             }

             final String jwt = authHeader.substring(7);
             final String username = jwtService.extractUserName(jwt);

             Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

             if(username != null && authentication ==null){
                //authenticate
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);  //load username from db
                if(jwtService.isTokenValid(jwt,userDetails)){
                    //if token is valid it will send to USernamePassword authentication service
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);


                }
             }

             filterChain.doFilter(request, response);


 
    }

}
