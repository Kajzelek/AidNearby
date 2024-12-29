package com.app.AidNearby.config;

import com.app.AidNearby.services.impl.JWTserviceImpl;
import com.app.AidNearby.services.impl.MyUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

@Component
@AllArgsConstructor
public class JwtHandshakeInterceptor implements HandshakeInterceptor {

    private final JWTserviceImpl jwtService;
    private final MyUserDetailsService userDetailsService; // Dodaj zależność

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        // Pobranie tokena JWT z URL
        String token = request.getURI().getQuery().split("=")[1]; // Zakładając, że token jest przekazany jako ?token=JWT

        if (token != null && !token.isEmpty()) {
            // Pobierz username z tokena
            String username = jwtService.extractUsername(token);

            // Załaduj userDetails
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // Teraz przekaż oba argumenty do metody validateToken
            if (jwtService.validateToken(token, userDetails)) {
                attributes.put("username", username);  // Dodaj nazwę użytkownika do atrybutów połączenia WebSocket
                return true;  // Po zweryfikowaniu tokena połączenie jest dozwolone
            }
        }

        response.setStatusCode(HttpStatus.UNAUTHORIZED); // Jeśli token jest niepoprawny
        return false; // Zablokuj połączenie
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
                               WebSocketHandler wsHandler, Exception ex) {
        // Możesz dodać logowanie lub inne działania po handshake
    }
}