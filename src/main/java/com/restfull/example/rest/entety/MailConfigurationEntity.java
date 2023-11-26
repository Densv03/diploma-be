package com.restfull.example.rest.entety;

import com.restfull.example.rest.shared.dto.Style;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@Table(name = "receiver_user")
@NoArgsConstructor
public class MailConfigurationEntity {
    @Id
    private UUID id;
    @Column(name = "template_count")
    private Integer templateCount = 1;
    @Column(name = "using_place_holder")
    @Builder.Default
    private Boolean usingPlaceHolder = Boolean.FALSE;
    @Column(name = "sentence_count")
    private Integer sentenceCount = 4;
    @Column(name = "from name")
    private String fromName; // enum?
    @Column(name = "style")
    private Style  style;
}

