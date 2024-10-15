package com.app.AidNearby.domain.Entities;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_credentials")
public class UserCredentialsEntity {
    @Id
    private UUID credentielsId;
    private UUID userId;
    private String profilePicture;
    private String bio;
    private int age;
    @ElementCollection
    private List<String> interests; //TODO: Check if this works
}
