package com.app.AidNearby.services.impl;

import com.app.AidNearby.Exceptions.NotAuthorizedException;
import com.app.AidNearby.domain.DTO.chatDTO.ConversationDTO;
import com.app.AidNearby.domain.Entities.chat.ConversationEntity;
import com.app.AidNearby.mappers.impl.ConversationMapper;
import com.app.AidNearby.repository.ConversationRepository;
import com.app.AidNearby.services.servicesInterfaces.ConversationService;
import com.app.AidNearby.services.servicesInterfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ConversationServiceImpl implements ConversationService {

    private final ConversationRepository conversationRepository;
    private final ConversationMapper conversationMapper;
    private final UserService userService;

    @Override
    public ConversationDTO createConversation(ConversationDTO conversationDTO, UUID userId) {

        System.out.println("DTO: " + conversationDTO);
        ConversationEntity conversationEntity = conversationMapper.mapToEntity(conversationDTO);

        conversationEntity.setUser1(userService.getUserById(userId)); // user1 is the user who created the conversation


        ConversationEntity savedEntity = conversationRepository.save(conversationEntity);
        return conversationMapper.mapToDto(savedEntity);
    }


//    @Override
//    public List<ConversationDTO> getAllConversations(UUID userId) {
//        return conversationRepository.findAll().stream()
//                .map(conversationMapper::mapToDto)
//                .collect(Collectors.toList());
//    }

    @Override
    public List<ConversationDTO> getAllConversations(UUID userId) {
        return conversationRepository.findAllConversationsByUserId(userId).stream()
                .map(conversationMapper::mapToDto)
                .collect(Collectors.toList());
    }
//


    @Override
    public void deleteConversation(UUID conversationId, UUID userId) {
        ConversationEntity conversationEntity = conversationRepository.findById(conversationId)
                .orElseThrow(() -> new RuntimeException("Conversation not found"));

        if (conversationEntity.getUser1().getUserId().equals(userId)) {
            conversationRepository.delete(conversationEntity);
        } else {
            throw new NotAuthorizedException("You are not allowed to delete this conversation");
        }
    }

    @Override
    public ConversationEntity getConversationById(UUID id, UUID userId) {
        return conversationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conversation not found"));
    }


    @Override
    public Boolean conversationExists(UUID user1Id, UUID user2Id) {
        return conversationRepository.findConversationByUser1IdAndUser2Id(user1Id, user2Id) != null ||
                conversationRepository.findConversationByUser1IdAndUser2Id(user2Id, user1Id) != null;
    }

}