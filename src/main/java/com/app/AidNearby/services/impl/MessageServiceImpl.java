package com.app.AidNearby.services.impl;

import com.app.AidNearby.domain.DTO.chatDTO.MessageDTO;
import com.app.AidNearby.domain.Entities.chat.ConversationEntity;
import com.app.AidNearby.domain.Entities.chat.MessageEntity;
import com.app.AidNearby.mappers.impl.MessageMapper;
import com.app.AidNearby.repository.ConversationRepository;
import com.app.AidNearby.repository.MessageRepository;
import com.app.AidNearby.services.servicesInterfaces.MessageService;
import com.app.AidNearby.services.servicesInterfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    private final ConversationRepository conversationRepository;
    private final UserService userService;


    @Override
    public MessageDTO createMessage(MessageDTO messageDTO, UUID userId) {
        MessageEntity messageEntity = messageMapper.mapToEntity(messageDTO);
        ConversationEntity conversationEntity;


        if(conversationRepository.findConversationByUser1IdAndUser2Id(userId, messageDTO.getReceiver()) != null){
            conversationEntity = conversationRepository.findConversationByUser1IdAndUser2Id(userId, messageDTO.getReceiver());
        }else{
            conversationEntity = conversationRepository.findConversationByUser1IdAndUser2Id(messageDTO.getReceiver(),userId);
        }

        System.out.print("XYZ CONVERSATION: " + conversationEntity);

        messageEntity.setSenderId(userId);
        messageEntity.setConversation(conversationEntity);

        MessageEntity savedEntity = messageRepository.save(messageEntity);
        return messageMapper.mapToDto(savedEntity);
    }

    @Override
    public List<MessageDTO> getAllMessages(UUID userId, UUID user2Id) {
        return messageRepository.findByConversation(conversationRepository.findConversationByUser1IdAndUser2Id(userId, user2Id)).stream()
                .map(messageMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MessageDTO> getAllMessagesByConversation(ConversationEntity conversation, UUID userId) {
        return messageRepository.findByConversation(conversation).stream()
                .map(messageMapper::mapToDto)
                .collect(Collectors.toList());
    }




    /*@Override
    public List<MessageDTO> getAllMessages(UUID userId, UUID receiverId) {
        return messageRepository.findAllBySenderAndReceiver(userId, receiverId).stream()
                .map(messageMapper::mapToDto)
                .collect(Collectors.toList());
    }*/
}
