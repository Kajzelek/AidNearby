package com.app.AidNearby.services.servicesInterfaces;

import com.app.AidNearby.domain.DTO.authDTO.AuthResponseDTO;
import com.app.AidNearby.domain.Entities.user.UserEntity;
import jakarta.servlet.http.HttpServletRequest;

public interface EntryService {
    UserEntity createUser(String password, String username, String email);
    AuthResponseDTO verify(String password, String username, HttpServletRequest request);
}
