package com.app.AidNearby.domain.Entities.chat;

import com.app.AidNearby.domain.Entities.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class ConversationEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID conversationId;

    @ManyToOne
    @JoinColumn(name = "user1_id")
    private UserEntity user1;

    private UUID user2Id;

    @OneToMany(mappedBy = "conversation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MessageEntity> messages;
}