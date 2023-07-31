package com.rkuryshev.messenger.security.utils;

import com.rkuryshev.messenger.entity.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class JwtTokenUtil {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.lifetime}")
    private Duration jwtLifeTime;

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList())
        );

        Date issuedDate = new Date();
        Date expiredDate = new Date(issuedDate.getTime() + jwtLifeTime.toMillis());
        System.out.println(userDetails.getUsername());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(issuedDate)
                .setExpiration(expiredDate)
                .signWith(getSignIn(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUsernameFromToken(String jwtToken) {
        return getAllClaimsFromToken(jwtToken).getSubject();
    }

    public List<String> getAllRolesFromToken(String jwtToken) {
        return getAllClaimsFromToken(jwtToken).get("roles", List.class);
    }

    private Claims getAllClaimsFromToken(String jwtToken) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignIn())
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    private Key getSignIn() {
//        byte[] bytes = Base64.getUrlDecoder().decode(secret);
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

}
