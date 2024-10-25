package com.app.AidNearby.domain.DTO.authDTO;

import com.app.AidNearby.domain.DTO.userDTO.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDTO {
    private UserDTO userDTO;
    private String token;
}
