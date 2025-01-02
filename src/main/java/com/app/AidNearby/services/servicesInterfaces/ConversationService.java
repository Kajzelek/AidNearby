package com.app.AidNearby.services.servicesInterfaces;

import com.app.AidNearby.domain.DTO.chatDTO.ConversationDTO;
import com.app.AidNearby.domain.Entities.chat.ConversationEntity;

import java.util.List;
import java.util.UUID;

public interface ConversationService {
    ConversationDTO createConversation(ConversationDTO conversationDTO, UUID userId);
    ConversationEntity getConversationById(UUID id, UUID userId);
    List<ConversationDTO> getAllConversations(UUID userId);
    Boolean conversationExists(UUID user1Id, UUID user2Id);
    void deleteConversation(UUID id, UUID userId);
}