package com.app.AidNearby.repository;

import com.app.AidNearby.domain.Entities.chat.ConversationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ConversationRepository extends JpaRepository<ConversationEntity, UUID> {
    // Additional query methods can be defined here
    @Query("SELECT c FROM ConversationEntity c WHERE c.user1.id = :user1Id AND c.user2Id = :user2Id")
    ConversationEntity findConversationByUser1IdAndUser2Id(@Param("user1Id") UUID user1Id, @Param("user2Id") UUID user2Id);

    @Query("SELECT c FROM ConversationEntity c WHERE c.user1.id = :userId OR c.user2Id = :userId")
    List<ConversationEntity> findAllConversationsByUserId(@Param("userId") UUID userId);
}