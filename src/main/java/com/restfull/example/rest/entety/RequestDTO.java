package com.restfull.example.rest.entety;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {

    private String name;

    private String lastName;

    private String email;

    private String password;

}
