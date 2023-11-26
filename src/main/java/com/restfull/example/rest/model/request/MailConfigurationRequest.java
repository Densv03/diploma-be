package com.restfull.example.rest.model.request;

import com.restfull.example.rest.shared.dto.Style;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MailConfigurationRequest {
    private Integer templateCount;
    private Boolean usingPlaceHolder = false;

    private String from;

    private Style style;

    private Integer sentenceCount;
}
