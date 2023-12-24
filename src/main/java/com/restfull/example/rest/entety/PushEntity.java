package com.restfull.example.rest.entety;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "push")
public class PushEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String template;
    @Column(name = "using_place_holder")
    private Boolean usingPlaceHolder = false;
    @Column(name = "from_name")
    private String from;
    private String email;
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "created_at")
    private OffsetDateTime createdAt = OffsetDateTime.now();
}
