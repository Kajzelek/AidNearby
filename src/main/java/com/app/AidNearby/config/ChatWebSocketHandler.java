package com.app.AidNearby.config;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Pobierz nazwę użytkownika z atrybutów sesji
        String username = (String) session.getAttributes().get("username");
        System.out.println("Połączono użytkownika: " + username);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Obsługa wiadomości
        String username = (String) session.getAttributes().get("username");
        System.out.println(username + " wysłał wiadomość: " + message.getPayload());
        session.sendMessage(new TextMessage("Odpowiedź: " + message.getPayload()));
    }
}