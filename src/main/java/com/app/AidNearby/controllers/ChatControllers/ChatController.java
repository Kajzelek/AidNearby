package com.app.AidNearby.controllers.ChatControllers;

import com.app.AidNearby.domain.Entities.chat.MessageEntity;
import com.app.AidNearby.repository.MessageRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ChatController {

    private final MessageRepository messageRepository;

    public ChatController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public MessageEntity sendMessage(MessageEntity message) {
        message.setTimestamp(LocalDateTime.now());
        return messageRepository.save(message);
    }
}