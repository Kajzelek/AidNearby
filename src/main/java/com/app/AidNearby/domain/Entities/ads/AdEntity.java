package com.app.AidNearby.domain.Entities.ads;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ads")
public class AdEntity {
    @Id
    private UUID adId;
    private UUID userId;
    private String adTitle;
    @ManyToOne
    private AdCategoryEntity adCategory;
    private String adDescription;
    private String adLocation;
    private Boolean adStatus;
}
