package com.restfull.example.rest.controller;

import com.restfull.example.rest.model.request.PushRequest;
import com.restfull.example.rest.service.PushEmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.http.Header;

import java.util.UUID;

@RestController
@RequestMapping(path="/push")
@AllArgsConstructor
public class PushEmailController {

    private final PushEmailService pushEmailService;

    @PostMapping
    public void pushEmail(@Header("UserId") UUID id, @RequestBody PushRequest request) {
       pushEmailService.push(id, request);
    }
    /**
     * request
     * label
     *
     */


}
