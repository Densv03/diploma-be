package com.restfull.example.rest.entety;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LabelEntity {
    @Id
    private UUID userId;
    @Id
    private UUID generatedTemplateId;
    private String description;
    private String name;

    private OffsetDateTime createdAt = OffsetDateTime.now();
}


