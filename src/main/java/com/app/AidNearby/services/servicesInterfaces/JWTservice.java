package com.app.AidNearby.services.servicesInterfaces;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;
import java.util.UUID;
import java.util.function.Function;

public interface JWTservice {
    String generateToken(String username, UUID uuid, String ipAddress, Double latitude, Double longitude);

    boolean validateToken(String token, UserDetails userDetails);

    Claims extractAllClaims(String token);

    String extractUsername(String token);

    boolean isTokenExpired(String token);

    String refreshToken(String token);

    SecretKey getKey();

    UUID extractSpecifiedClaim(String token, String type);

    <T> T extractClaim(String token, Function<Claims, T> claimResolver);
}
