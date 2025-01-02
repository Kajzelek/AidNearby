package com.app.AidNearby.controllers.ChatControllers;

import com.app.AidNearby.domain.DTO.adsDTO.AdDTO;
import com.app.AidNearby.domain.DTO.chatDTO.ConversationDTO;
import com.app.AidNearby.services.impl.ConversationServiceImpl;
import com.app.AidNearby.services.impl.JWTserviceImpl;
import com.app.AidNearby.services.servicesInterfaces.ConversationService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/conversations")
public class ConversationController {

    private final ConversationServiceImpl conversationServiceImpl;
    private final JWTserviceImpl jWTserviceImpl;

    @PostMapping("/createConversation")
    public ResponseEntity<ConversationDTO> createConversation(
            @RequestBody ConversationDTO conversationDTO,
            @RequestHeader("Authorization") String token) throws IOException {

        UUID userId = jWTserviceImpl.extractSpecifiedClaim(token, "userId");
        ConversationDTO conversation = conversationServiceImpl.createConversation(conversationDTO, userId);
        return new ResponseEntity<>(conversation, HttpStatus.CREATED);
    }

    @GetMapping("/getAllConversations")
    public ResponseEntity<List<ConversationDTO>> getAllConversations(
            @RequestHeader("Authorization") String token) throws IOException {

        UUID userId = jWTserviceImpl.extractSpecifiedClaim(token, "userId");
        List<ConversationDTO> conversations = conversationServiceImpl.getAllConversations(userId);
        return new ResponseEntity<>(conversations, HttpStatus.OK);
    }

    @GetMapping("/checkIfConversationExists")
    public ResponseEntity<Boolean> checkIfConversationExists(
            @RequestParam("user2Id") UUID user2Id,
            @RequestHeader("Authorization") String token) throws IOException {

        UUID userId = jWTserviceImpl.extractSpecifiedClaim(token, "userId");
        boolean exists = conversationServiceImpl.conversationExists(userId, user2Id);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }




}
