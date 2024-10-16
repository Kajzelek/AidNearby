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
@Table(name = "ad_applications")
public class AdApplicationEntity {
    @Id
    private UUID adApplicationId;
    private UUID userId;
    private UUID adId;
    private String applicationStatus;
    private Date submittedAt;
    private String userMessage;
    private Boolean isApproved;
}
