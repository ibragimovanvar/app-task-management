package com.ibragimov.apptaskmanagement.service.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

}
