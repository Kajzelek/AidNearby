package com.app.AidNearby.controllers.ChatControllers;

import com.app.AidNearby.domain.Entities.chat.MessageEntity;
import com.app.AidNearby.repository.MessageRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/conversations")
public class ConversationController {

    private final MessageRepository messageRepository;

    public ConversationController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/{userId}")
    public List<MessageEntity> getConversations(@PathVariable Long userId) {
        return messageRepository.findBySenderIdOrReceiverId(userId, userId);
    }
}