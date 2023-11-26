package com.restfull.example.rest.entety;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@Table(name = "generated_template")
@NoArgsConstructor
public class GeneratedTemplateEntity {
    //id
    @Id
    private UUID id;
    private String title;
    private String template;
    private OffsetDateTime createdAt = OffsetDateTime.now();

    private UUID labelId;

    private Boolean usingPlaceHolder = false;

}
