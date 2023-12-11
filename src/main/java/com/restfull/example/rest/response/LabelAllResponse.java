package com.restfull.example.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabelAllResponse {
    private String label;
    private OffsetDateTime createdAt = OffsetDateTime.now();
    private List<GenerateTemplateResponse> templates = new ArrayList<>();
}
