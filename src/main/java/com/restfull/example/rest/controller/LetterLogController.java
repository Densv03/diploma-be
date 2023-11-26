package com.restfull.example.rest.controller;

import jakarta.persistence.Id;

import java.time.OffsetDateTime;
import java.util.UUID;

public class LetterLogController {
    /**
     * GET /letterLog
     * get letter log Labels  ASC
     * {
     *   labelName : String
     *   labelDescription : String
     *
     * }
     */


    /**
     * GET /letterLog/{labelName}
     * get letter log Labels  ASC
     *  [{
     *  title :string,
     *  template: string
     *  usingPlaceHolders : boolean
     *
     *
     *  }]
     */


    /*

     */


    @Id
    private UUID id;
    private String title;
    private String template;
    private OffsetDateTime createdAt = OffsetDateTime.now();

    private UUID labelId;

    private Boolean usingPlaceHolder = false;
}
