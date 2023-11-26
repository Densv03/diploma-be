package com.restfull.example.rest.entety;

import jakarta.persistence.Column;
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
@Table(name = "mail_description")
@NoArgsConstructor
public class MailDescriptionEntity {
    @Id
    @Column(name = "mailId")
    private UUID mailId;
//    @Id
//    @Column(name = "userId")
//    private UUID userId;
    @Column(name = "tittle")
    private String tittle;
    @Column(name = "body")
    private String body;
}

