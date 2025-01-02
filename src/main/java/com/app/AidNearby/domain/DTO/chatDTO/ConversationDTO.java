package com.app.AidNearby.domain.DTO.chatDTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConversationDTO {
    private UUID conversationId;
    private UUID user1;
    private UUID user2;
}
