package com.app.AidNearby.services.impl;

import com.app.AidNearby.services.servicesInterfaces.JWTservice;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.*;
import java.util.function.Function;

@Service
public class JWTserviceImpl implements JWTservice {

    private UserServiceImpl userService;
    private String secretKey;

    public JWTserviceImpl(UserServiceImpl userService) {
        this.userService = userService;

        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk = keyGen.generateKey();
            secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public String generateToken(String username, UUID uuid, String ipAddress) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", uuid);
        claims.put("ipAddress", ipAddress);

        return Jwts.builder().claims().add(claims).subject(username).issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 30 * 30))
                .and().signWith(getKey())
                .compact();
    }


    @Override
    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        final UUID uuid = extractSpecifiedClaim(token, "userId");
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    @Override
    public Claims extractAllClaims(String token) {
        return null;
    }

    @Override
    public String extractUsername(String token) {
        return "";
    }

    @Override
    public boolean isTokenExpired(String token) {
        return false;
    }

    @Override
    public String refreshToken(String token) {
        return "";
    }

    @Override
    public SecretKey getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public UUID extractSpecifiedClaim(String token, String type) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        return extractClaim(token, claims -> UUID.fromString(claims.get(type, String.class)));
    }

    @Override
    public <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }
}
