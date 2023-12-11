package com.restfull.example.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GroupResponse {
    private String groupName;
    private List<EmailReceiverResponse> emailReceiverResponses = new ArrayList<>();
}
