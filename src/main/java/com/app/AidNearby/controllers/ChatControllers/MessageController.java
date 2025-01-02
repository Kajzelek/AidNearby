package com.app.AidNearby.controllers.ChatControllers;


import com.app.AidNearby.domain.DTO.chatDTO.MessageDTO;
import com.app.AidNearby.domain.Entities.chat.ConversationEntity;
import com.app.AidNearby.services.impl.ConversationServiceImpl;
import com.app.AidNearby.services.impl.JWTserviceImpl;
import com.app.AidNearby.services.impl.MessageServiceImpl;
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
@RequestMapping("/conversations/{conversationId}")
public class MessageController {

        private final MessageServiceImpl messageServiceImpl;
        private final ConversationServiceImpl conversationServiceImpl;
        private final JWTserviceImpl jWTserviceImpl;

        @PostMapping("/sendMessage")
        public ResponseEntity<MessageDTO> sendMessage(
                @RequestBody MessageDTO messageDTO,
                @RequestHeader("Authorization") String token) throws IOException {

            UUID userId = jWTserviceImpl.extractSpecifiedClaim(token, "userId");
            MessageDTO message = messageServiceImpl.createMessage(messageDTO, userId);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }

        @GetMapping("/getAllMessages")
        public ResponseEntity<List<MessageDTO>> getAllMessages(
                @PathVariable UUID conversationId,
                @RequestHeader("Authorization") String token) throws IOException {

            UUID userId = jWTserviceImpl.extractSpecifiedClaim(token, "userId");

            ConversationEntity conversation = conversationServiceImpl.getConversationById(conversationId, userId);
            UUID user2Id;

            if(userId.equals(conversation.getUser2Id())){
                user2Id = conversation.getUser1().getUserId();
            } else {
                user2Id = conversation.getUser2Id();
            }


            List<MessageDTO> messages = messageServiceImpl.getAllMessages(userId, user2Id);
            System.out.println("XYZ MESSAGES: " + messages);
            return new ResponseEntity<>(messages, HttpStatus.OK);
        }


    @GetMapping("/getAllMessagesByConversation")
    public ResponseEntity<List<MessageDTO>> getAllMessagesByConversation(
            @PathVariable UUID conversationId,
            @RequestHeader("Authorization") String token) throws IOException {

        UUID userId = jWTserviceImpl.extractSpecifiedClaim(token, "userId");

        ConversationEntity conversation = conversationServiceImpl.getConversationById(conversationId, userId);

        List<MessageDTO> messages = messageServiceImpl.getAllMessagesByConversation(conversation, userId);
        System.out.println("XYZ MESSAGES: " + messages);
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
}
