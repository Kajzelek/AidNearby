package com.app.AidNearby.controllers.AdControllers;


import com.app.AidNearby.domain.DTO.adsDTO.AdApplicationDTO;
import com.app.AidNearby.domain.Entities.ads.AdApplicationEntity;
import com.app.AidNearby.services.impl.JWTserviceImpl;
import com.app.AidNearby.services.servicesInterfaces.AdApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/adApplications")
public class AdApplicationController {
    private final AdApplicationService adApplicationService;
    private final JWTserviceImpl jWTserviceImpl;

    @PostMapping("/createAdApplication")
    public ResponseEntity<AdApplicationDTO> createAdApplication(@RequestBody AdApplicationDTO adApplicationDTO,
                                                                @RequestHeader("Authorization") String token) {
        UUID userId = jWTserviceImpl.extractSpecifiedClaim(token, "userId");
        AdApplicationDTO adApplication = adApplicationService.createAdApplication(adApplicationDTO, userId);
        return new ResponseEntity<>(adApplication, HttpStatus.CREATED);
    }

    @DeleteMapping("/{adApplicationId}")
    public ResponseEntity<String> deleteAdApplication(@PathVariable UUID adApplicationId,
                                                      @RequestHeader("Authorization") String token) {
        UUID userId = jWTserviceImpl.extractSpecifiedClaim(token, "userId");
        String message = adApplicationService.deleteAdApplication(adApplicationId, userId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/getAdApplications/{adId}")
    public ResponseEntity<List<AdApplicationDTO>> getAdApplications(@PathVariable UUID adId,
                                                                    @RequestHeader("Authorization") String token) {
        UUID userId = jWTserviceImpl.extractSpecifiedClaim(token, "userId");
        List<AdApplicationDTO> adApplications = adApplicationService.getAdApplications(adId, userId);
        return new ResponseEntity<>(adApplications, HttpStatus.OK);
    }

    @GetMapping("/getAdApplicationsByAdCreatorId")
    public ResponseEntity<List<AdApplicationDTO>> getAdApplicationsByAdCreatorId(@RequestHeader("Authorization") String token) {
        UUID userId = jWTserviceImpl.extractSpecifiedClaim(token, "userId");
        List<AdApplicationDTO> adApplications = adApplicationService.getAdApplicationsByAdCreatorId(userId);
        return new ResponseEntity<>(adApplications, HttpStatus.OK);
    }


}
