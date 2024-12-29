package com.app.AidNearby.repository;

import com.app.AidNearby.domain.Entities.chat.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
    List<MessageEntity> findBySenderIdOrReceiverId(Long senderId, Long receiverId);
}