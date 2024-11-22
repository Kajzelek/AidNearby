package com.app.AidNearby.domain.Entities.ads;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    private UUID adCategoryId;
    private String categoryName;
    private String categoryDescription;
    private String categoryIcon;
    @OneToMany(mappedBy = "adCategory")
    private List<AdEntity> categoryAds;
}
