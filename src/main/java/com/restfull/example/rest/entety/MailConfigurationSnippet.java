package com.restfull.example.rest.entety;

import jakarta.persistence.Id;

import java.time.OffsetDateTime;
import java.util.UUID;

public class MailConfigurationSnippet {
    @Id
    private UUID userId;
    @Id
    private UUID mailDescriptionId;
    @Id
    private UUID mailConfigurationId;
    private OffsetDateTime createdAt = OffsetDateTime.now();
}
