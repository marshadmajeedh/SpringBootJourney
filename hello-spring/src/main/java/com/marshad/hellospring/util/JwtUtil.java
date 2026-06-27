package com.marshad.hellospring.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    //This key is used to sign and verify tokens
    private final String SECRET_KEY = "mysecretkeymysecretkeymysecretkey12";

    private Key getSigningKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    //Creates a JWT with the username inside expires in 24 hours
    public String generateToken(String username){
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(getSigningKey())
                .compact();
    }

    //reads the username out of a token
    public String extractUsername(String token){
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    //Checks if a token is valid and not expired
    public boolean isTokenValid(String token){
        try{
            extractUsername(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
