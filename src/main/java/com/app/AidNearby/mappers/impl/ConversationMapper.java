package com.app.AidNearby.mappers.impl;

import com.app.AidNearby.domain.DTO.chatDTO.ConversationDTO;
import com.app.AidNearby.domain.Entities.chat.ConversationEntity;
import org.springframework.stereotype.Component;

@Component
public class ConversationMapper {

    public ConversationDTO mapToDto(ConversationEntity conversationEntity) {
        return ConversationDTO.builder()
                .conversationId(conversationEntity.getConversationId())
                .user1(conversationEntity.getUser1().getUserId())
                .user2(conversationEntity.getUser2Id())
                .build();
    }

   public ConversationEntity mapToEntity(ConversationDTO conversationDTO) {
        return ConversationEntity.builder()
                .user2Id(conversationDTO.getUser2())
                .build();
    }
}
