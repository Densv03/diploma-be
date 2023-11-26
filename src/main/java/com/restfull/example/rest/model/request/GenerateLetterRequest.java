package com.restfull.example.rest.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GenerateLetterRequest {
    GenerateLabelRequest generateLabelRequest;
    GenerateMailDescriptionRequest generateMailDescriptionRequest;
    MailConfigurationRequest mailConfigurationRequest;
}
