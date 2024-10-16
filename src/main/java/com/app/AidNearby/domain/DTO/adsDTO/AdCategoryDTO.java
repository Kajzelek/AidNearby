package com.app.AidNearby.domain.DTO.adsDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdCategoryDTO {
    private String categoryName;
    private String categoryDescription;
    private String categoryIcon;
}
