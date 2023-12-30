package com.ibragimov.apptaskmanagement.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthResponse {
    private String jwt;
    private  boolean successful;
    private int statusCode;
}
