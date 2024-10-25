package com.app.AidNearby.controllers.EntryControllers;

import com.app.AidNearby.domain.Entities.user.UserEntity;
import com.app.AidNearby.mappers.impl.UserMapper;
import com.app.AidNearby.services.impl.EntryServiceImpl;
import org.springframework.http.ResponseEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EntryController {
    private final EntryServiceImpl entryService;
    private final UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestParam String password, @RequestParam String username, @RequestParam String email){
        UserEntity savedUserEntity = entryService.createUser(password, username, email);
        return new ResponseEntity<>(userMapper.mapToDto(savedUserEntity), org.springframework.http.HttpStatus.CREATED);
    }
}
