// AdCategoriesController.java
package com.app.AidNearby.controllers.AdControllers;

import com.app.AidNearby.domain.DTO.adsDTO.AdCategoryDTO;
import com.app.AidNearby.domain.Entities.ads.AdCategoryEntity;
import com.app.AidNearby.mappers.impl.AdCategoryMapper;
import com.app.AidNearby.services.impl.AdCategoryServiceImpl;
import com.app.AidNearby.services.impl.JWTserviceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/ad-categories")
public class AdCategoriesController {
    private final AdCategoryServiceImpl adCategoryServiceImpl;
    private final AdCategoryMapper adCategoryMapper;
    private final JWTserviceImpl JWTserviceImpl;

    @GetMapping
    public ResponseEntity<List<AdCategoryDTO>> getAllCategories(@RequestHeader("Authorization") String token) {
        UUID userId = JWTserviceImpl.extractSpecifiedClaim(token, "userId");
        List<AdCategoryDTO> categories = adCategoryServiceImpl.getAdsCategories(userId);
        return ResponseEntity.ok(categories);
    }
}