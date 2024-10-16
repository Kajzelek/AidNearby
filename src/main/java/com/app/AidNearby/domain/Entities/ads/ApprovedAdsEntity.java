package com.app.AidNearby.domain.Entities.ads;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "approved_ads")
public class ApprovedAdsEntity {
    @Id
    private UUID approvedAdId;
    private UUID userId;
    private UUID adId;
    private Date assignedAt;
    private String taskStatus;
    private Date completedAt;
}
