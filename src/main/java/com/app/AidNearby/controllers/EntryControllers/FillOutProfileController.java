package com.app.AidNearby.controllers.EntryControllers;

import com.app.AidNearby.domain.DTO.userDTO.ProfileDataDTO;
import com.app.AidNearby.domain.Entities.user.UserEntity;
import com.app.AidNearby.services.impl.UserServiceImpl;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class FillOutProfileController {
    private final UserServiceImpl userServiceImpl;

    public FillOutProfileController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/FillOutProfile")
    public ResponseEntity<?> FillOutProfile(@RequestBody ProfileDataDTO profileDataDTO, @RequestParam UUID userId){
        String response = userServiceImpl.fillOutProfile(profileDataDTO, userId);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
