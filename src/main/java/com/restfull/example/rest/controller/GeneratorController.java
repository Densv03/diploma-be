package com.restfull.example.rest.controller;

import com.restfull.example.rest.model.request.GenerateLetterRequest;
import com.restfull.example.rest.service.GeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.http.Header;

import java.util.UUID;

@RestController
@RequestMapping(path="/generator")
@AllArgsConstructor
public class GeneratorController {

    private final GeneratorService generatorService;

    @PostMapping()
    String generateTemplate(@RequestHeader("UserId") UUID id, @RequestBody GenerateLetterRequest request){
        return generatorService.generateTemplate(id, request);
    }


}
