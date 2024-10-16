package com.app.AidNearby.domain.DTO.userDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private UUID userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private Float subsidarityAvgRating;
}
