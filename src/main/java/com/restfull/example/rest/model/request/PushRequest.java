package com.restfull.example.rest.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class PushRequest {
    private String title;
    private String template;
    private Boolean usingPlaceHolder = false;
    private String groupName;
    private String from;
    private List<PushEmailRequest> pushEmailRequests = new ArrayList<>();
}
