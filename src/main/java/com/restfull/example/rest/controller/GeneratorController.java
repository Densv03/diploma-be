package com.restfull.example.rest.controller;

import com.restfull.example.rest.model.request.GenerateLetterRequest;
import com.restfull.example.rest.service.GeneratorService;
import com.restfull.example.rest.shared.dto.Style;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/generator")
@AllArgsConstructor
public class GeneratorController {

    private final GeneratorService generatorService;

    /*
     Post DOMAIN/generate
     {
     label : { name : String , description : String }
     mailDescription : { title : String , body : String }
     mailConfiguration : {
            templateCount : Integer,
            usingPlaceHolder : Boolean,
            sentenceCount : Integer,
            fromName : String (Will change it),
            style: Enum
            }
     }
     */

    @PostMapping
    String generateTemplate(@RequestBody GenerateLetterRequest request ){
        return generatorService.generateTemplate(request);
    }


}
