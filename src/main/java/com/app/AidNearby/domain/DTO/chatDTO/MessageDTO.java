package com.app.AidNearby.domain.DTO.chatDTO;

import com.app.AidNearby.domain.DTO.userDTO.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDTO {
    private Long id;
    private UUID sender;
    private UUID receiver;
    private String content;
    private Date MessageTimestamp;
}
