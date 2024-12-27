package com.app.AidNearby.domain.DTO.adsDTO;

import com.app.AidNearby.domain.Entities.ads.AdCategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdDTO {
    private UUID adId;
    private UUID userId;
    private String adTitle;
    private String helpType;
    private String adCategory;
    private String adDescription;
    private String adLocation;
    private Double latitude;
    private Double longitude;

    //private String adStatus;
    //private String imagePath;
    //private String adImage;
}
