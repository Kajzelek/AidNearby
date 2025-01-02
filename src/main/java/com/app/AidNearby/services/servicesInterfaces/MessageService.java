package com.app.AidNearby.services.servicesInterfaces;


import com.app.AidNearby.domain.DTO.chatDTO.MessageDTO;
import com.app.AidNearby.domain.Entities.chat.ConversationEntity;

import java.util.List;
import java.util.UUID;

public interface MessageService {
    MessageDTO createMessage(MessageDTO messageDTO, UUID userId);
    List<MessageDTO> getAllMessages(UUID user1, UUID user2Id);
    List<MessageDTO> getAllMessagesByConversation(ConversationEntity conversation, UUID userId);
}
