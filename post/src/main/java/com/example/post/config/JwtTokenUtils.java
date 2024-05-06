package com.example.post.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtils {

    //     만료 시간이 존재 한다(ms)
    @Value("${token.expiration}")
    private Long tokenExpiration;
    //    secretkey 존재한다
    @Value("${token.secret}")
    private String tokenSecret;


//     토큰 parse
    public TokenInfo parseToken(String token){
        Claims payload = (Claims) Jwts
                .parser()
                .verifyWith(Keys.hmacShaKeyFor(tokenSecret.getBytes()))
                .build()
                .parse(token)
                .getPayload();
        return TokenInfo.fromClaims(payload);
    }

}