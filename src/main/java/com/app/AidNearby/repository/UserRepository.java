package com.app.AidNearby.repository;

import com.app.AidNearby.domain.Entities.chat.ConversationEntity;
import com.app.AidNearby.domain.Entities.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    UserEntity findByUsername(String username);

    @Query("SELECT u.id FROM UserEntity u WHERE " +
            "(6371 * acos(cos(radians(:latitude)) * cos(radians(u.latitude)) * cos(radians(u.longitude) - radians(:longitude)) + sin(radians(:latitude)) * sin(radians(u.latitude)))) < 20")
    List<UUID> findUsersWithinRadius(@Param("latitude") double latitude, @Param("longitude") double longitude);
}
