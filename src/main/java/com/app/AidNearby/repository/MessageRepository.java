package com.app.AidNearby.repository;

import com.app.AidNearby.domain.Entities.chat.ConversationEntity;
import com.app.AidNearby.domain.Entities.chat.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
    @Query("SELECT m FROM MessageEntity m WHERE m.senderId = :senderId AND m.receiverId = :receiverId")
    List<MessageEntity> findBySenderIdAndReceiverId(@Param("senderId") UUID senderId, @Param("receiverId") UUID receiverId);

    List<MessageEntity> findByConversation(ConversationEntity conversation);
}