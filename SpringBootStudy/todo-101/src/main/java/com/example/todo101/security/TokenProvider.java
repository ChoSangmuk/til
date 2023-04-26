package com.example.todo101.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import com.example.todo101.model.UserEntity;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenProvider {
  private static final String SECRET_KEY = "asdqwwdadqwddgdsfa";

  public String create(UserEntity entity) {
    return Jwts
        .builder()
        .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
        .setSubject(entity.getId())
        .setIssuer("todo App")
        .setIssuedAt(new Date())
        .setExpiration(Date.from(Instant.now().plus(1, ChronoUnit.DAYS)))
        .compact();
  }

  public String validateAndGetUserId(String token) {
    Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    return claims.getSubject();
  }
}
