package com.wings.jwt.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.wings.jwt.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
   

    public String generateToken(User user) {
        
        Map< String,  Object> claims= new HashMap<>();
        return Jwts
        .builder()
        .claims()
        .add(claims)
        .subject(user.getUserName())
        .issuer("Pranay")
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis()+ 60*10*1000))
        .and()
        .signWith(SECRET_KEY, SignatureAlgorithm.HS512)
        .compact();
    }


    public String extractUserName(String jwt) {
       return extractClaims(jwt, Claims::getSubject);
    }

    private <T> T extractClaims(String jwt, Function<Claims,T> claimResolver){
        Claims claims = extractClaims(jwt);
        return claimResolver.apply(claims);
    }

    private Claims extractClaims(String jwt) {
       return Jwts
                .parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(jwt)
                .getPayload();

    }


    public boolean isTokenValid(String jwt, UserDetails userDetails) {
        final String userName = extractUserName(jwt);

        return (userName.equals(userDetails.getUsername()) && !isTokenEXpired(jwt));
    }


    private boolean isTokenEXpired(String jwt) {
        return extractExpiration(jwt).before(new Date());
    
    }


    private Date extractExpiration(String jwt) {
        return extractClaims(jwt, Claims::getExpiration);
    }





}
