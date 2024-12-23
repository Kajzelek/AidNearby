package com.app.AidNearby.controllers.EntryControllers;

import com.app.AidNearby.domain.DTO.userDTO.ProfileDataDTO;
import com.app.AidNearby.domain.Entities.user.UserEntity;
import com.app.AidNearby.services.impl.JWTserviceImpl;
import com.app.AidNearby.services.impl.UserServiceImpl;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class FillOutProfileController {
    private final UserServiceImpl userServiceImpl;
    private final JWTserviceImpl JWTserviceImpl;

//    public FillOutProfileController(UserServiceImpl userServiceImpl) {
//        this.userServiceImpl = userServiceImpl;
//    }

    @PostMapping("/FillOutProfile")
    public ResponseEntity<?> FillOutProfile(@RequestBody ProfileDataDTO profileDataDTO, @RequestHeader("Authorization") String token){
        UUID userId = JWTserviceImpl.extractSpecifiedClaim(token, "userId");
        String response = userServiceImpl.fillOutProfile(profileDataDTO, userId);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getProfile")
    public ResponseEntity<?> getProfile(@RequestParam("userId") UUID userId){
        ProfileDataDTO profileDataDTO = userServiceImpl.getProfile(userId);
        return new ResponseEntity<>(profileDataDTO, HttpStatus.OK);
    }
}
