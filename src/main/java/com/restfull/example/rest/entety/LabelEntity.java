package com.restfull.example.rest.entety;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "label")
@Entity
public class LabelEntity {
    @Column(name = "user_id")
    private UUID userId;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "label_id")
    private UUID labelId;
    private String description;
    private String name;
    @Column(name = "created_at")
    private OffsetDateTime createdAt = OffsetDateTime.now();
}


