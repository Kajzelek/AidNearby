package com.app.AidNearby.controllers.AdControllers;

import com.app.AidNearby.domain.DTO.adsDTO.AdDTO;
import com.app.AidNearby.services.impl.AdServiceImpl;
import com.app.AidNearby.services.impl.JWTserviceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/search/anyCategory")
    public ResponseEntity<List<AdDTO>> searchAds(
            @RequestParam Double latitude,
            @RequestParam Double longitude,
            @RequestParam Double radius) {

        List<AdDTO> ads = adService.searchAds(latitude, longitude, radius);
        return new ResponseEntity<>(ads, HttpStatus.OK);
    }

    @GetMapping("/searchByStatus/anyCategory")
    public ResponseEntity<List<AdDTO>> searchAds(
            @RequestParam Double latitude,
            @RequestParam Double longitude,
            @RequestParam Double radius,
            @RequestParam String status) {

        List<AdDTO> ads = adService.searchAdsByStatus(latitude, longitude, radius, status);
        return new ResponseEntity<>(ads, HttpStatus.OK);
    }

    @GetMapping("/searchByStatus")
    public ResponseEntity<List<AdDTO>> searchAdsByStatus(
            @RequestParam String category,
            @RequestParam Double latitude,
            @RequestParam Double longitude,
            @RequestParam Double radius,
            @RequestParam String status) {

        List<AdDTO> ads = adService.searchAdsByCategoryStatus(category, latitude, longitude, radius, status);
        return new ResponseEntity<>(ads, HttpStatus.OK);
    }

    @GetMapping("/{adId}")
    public ResponseEntity<AdDTO> getAdById(@PathVariable UUID adId) {
        AdDTO ad = adService.getAdById(adId);
        return new ResponseEntity<>(ad, HttpStatus.OK);
    }

    @GetMapping("/getAdsByUserId")
    public ResponseEntity<List<AdDTO>> getAdsByStatus(@RequestParam String status,
                                                      @RequestHeader("Authorization") String token) {
        UUID userId = JWTserviceImpl.extractSpecifiedClaim(token, "userId");
        List<AdDTO> ads = adService.getAdsByStatusAndUserId(status, userId);
        return new ResponseEntity<>(ads, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAd(@RequestParam UUID adId,
                                           @RequestHeader("Authorization") String token) {
        UUID userId = JWTserviceImpl.extractSpecifiedClaim(token, "userId");
        adService.deleteAd(adId, userId);
        return new ResponseEntity<>("Ad deleted", HttpStatus.OK);
    }

    @PutMapping("/closeAd")
    public ResponseEntity<AdDTO> closeAd(@RequestParam UUID adId,
                                          @RequestHeader("Authorization") String token) {
        UUID userId = JWTserviceImpl.extractSpecifiedClaim(token, "userId");
        AdDTO ad = adService.closeAd(adId, userId);
        return new ResponseEntity<>(ad, HttpStatus.OK);
    }


}
