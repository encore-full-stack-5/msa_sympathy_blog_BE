package com.example.user.global.utils;

import com.example.user.dto.request.UserBlogRequest;
import com.example.user.global.dto.UserBlogDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private final Long expiration;
    private final SecretKey secretKey;

    public JwtUtil(@Value("${jwt.expiration}") Long expiration,
                   @Value("${jwt.secret}") String secret)
    {
        this.expiration = expiration;
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(UserBlogDto req) {
        String token = Jwts.builder()
                .claim("id", req.id())
                .claim("email", req.email())
                .claim("nickname", req.nickname())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(secretKey)
                .compact();
        return token;
    }

    public String getByEmailFromTokenAndValidate(String token) {
        Claims payload = (Claims) Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parse(token)
                .getPayload();
        return payload.getSubject();
    }

}
