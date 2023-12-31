package com.ibragimov.apptaskmanagement.security.auth;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME )
@Target({ElementType.PARAMETER})
@AuthenticationPrincipal
public @interface LoggedInUser {

}
