package com.app.AidNearby.domain.DTO.userDTO;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCredentialsDTO {
    private UUID userId;
    private String profilePicture;
    private String bio;
    private int age;
    private List<String> interests;
}
