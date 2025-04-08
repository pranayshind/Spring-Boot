package com.wings.jwt.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.wings.jwt.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    public String generateToken(User user) {
        
        final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512)
        
        Map< String, Object> claims = new HashMap<>();
        return Jwts
               .builder()
               .claims()
               .add(claims)
               .subject(user.getUserName())
               .issuer("Pranay")
               .issuedAt(new Date(System.currentTimeMillis()))
               .expiration(new Date(System.currentTimeMillis() +  60*10*1000))
               .and()
               .signWith(SECRET_KEY, SignatureAlgorithm.HS512)
               .compact();



    }





}
