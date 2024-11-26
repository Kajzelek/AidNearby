package com.app.AidNearby.domain.Entities.ads;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ad_categories")
public class AdCategoryEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID adCategoryId;
    private String categoryName;
    private String categoryDescription;
    private String categoryIcon;
    @OneToMany(mappedBy = "adCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AdEntity> categoryAds;
}
