package com.app.AidNearby.controllers.AdControllers;

import com.app.AidNearby.domain.DTO.adsDTO.AdDTO;
import com.app.AidNearby.mappers.impl.AdMapper;
import com.app.AidNearby.services.impl.AdServiceImpl;
import com.app.AidNearby.services.impl.JWTserviceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/ads")
public class AdController {
    private final AdServiceImpl adService;
    private final JWTserviceImpl JWTserviceImpl;

    @PostMapping("/createAd")
    public ResponseEntity<AdDTO> createAd(@RequestBody AdDTO adDTO, @RequestHeader("Authorization") String token) throws IOException {
        UUID userId = JWTserviceImpl.extractSpecifiedClaim(token, "userId");
        AdDTO ad = adService.createAd(adDTO, userId);
        return new ResponseEntity<>(ad, HttpStatus.CREATED);
    }
}
