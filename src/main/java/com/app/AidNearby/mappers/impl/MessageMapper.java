package com.app.AidNearby.mappers.impl;

import com.app.AidNearby.domain.DTO.chatDTO.MessageDTO;
import com.app.AidNearby.domain.Entities.chat.MessageEntity;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

        public MessageDTO mapToDto(MessageEntity messageEntity) {
            return MessageDTO.builder()
                    .id(messageEntity.getId())
                    .receiver(messageEntity.getReceiverId())
                    .sender(messageEntity.getSenderId())
                    .MessageTimestamp(messageEntity.getMessageTimestamp())
                    .content(messageEntity.getContent())
                    .build();
        }

        public MessageEntity mapToEntity(MessageDTO messageDTO) {
            return MessageEntity.builder()
                    .receiverId(messageDTO.getReceiver())
                    .content(messageDTO.getContent())
                    .build();
        }
}
