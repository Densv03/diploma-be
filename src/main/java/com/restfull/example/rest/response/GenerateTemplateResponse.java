package com.restfull.example.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerateTemplateResponse {
    private String title;
    private String template;
    private Boolean usingPlaceHolder = false;

}
