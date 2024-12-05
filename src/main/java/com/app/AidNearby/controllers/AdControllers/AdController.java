package com.app.AidNearby.controllers.AdControllers;

import com.app.AidNearby.domain.DTO.adsDTO.AdDTO;
import com.app.AidNearby.mappers.impl.AdMapper;
import com.app.AidNearby.services.impl.AdServiceImpl;
import com.app.AidNearby.services.impl.JWTserviceImpl;
import lombok.AllArgsConstructor;
import org.hibernate.query.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/ads")
public class AdController {
    private final AdServiceImpl adService;
    private final JWTserviceImpl JWTserviceImpl;

    @PostMapping("/createAd")
    public ResponseEntity<AdDTO> createAd(@RequestBody AdDTO adDTO,
                                          //@RequestPart(value = "file", required = false) MultipartFile file,
                                          @RequestHeader("Authorization") String token) throws IOException {

        UUID userId = JWTserviceImpl.extractSpecifiedClaim(token, "userId");
        AdDTO ad = adService.createAd(adDTO, userId);
        return new ResponseEntity<>(ad, HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<AdDTO>> searchAds(
            @RequestParam String category,
            @RequestParam Double latitude,
            @RequestParam Double longitude,
            @RequestParam Double radius) {

        List<AdDTO> ads = adService.searchAds(category, latitude, longitude, radius);
        return new ResponseEntity<>(ads, HttpStatus.OK);
    }

    @GetMapping("/{adId}")
    public ResponseEntity<AdDTO> getAdById(@PathVariable UUID adId) {
        AdDTO ad = adService.getAdById(adId);
        return new ResponseEntity<>(ad, HttpStatus.OK);
    }


}
