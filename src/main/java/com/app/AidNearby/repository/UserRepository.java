package com.app.AidNearby.repository;

import com.app.AidNearby.domain.Entities.chat.ConversationEntity;
import com.app.AidNearby.domain.Entities.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    UserEntity findByUsername(String username);
}
