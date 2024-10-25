package com.app.AidNearby.controllers.AdControllers;

import com.app.AidNearby.domain.DTO.adsDTO.AdDTO;
import com.app.AidNearby.mappers.impl.AdMapper;
import com.app.AidNearby.services.impl.AdServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/ads")
public class AdController {
    private final AdServiceImpl adService;

    @PostMapping("/createAd")
    public ResponseEntity<AdDTO> createAd(@RequestBody AdDTO adDTO, @RequestParam UUID userId) {
        AdDTO ad = adService.createAd(adDTO, userId);
        return new ResponseEntity<>(ad, HttpStatus.CREATED);
    }
}
