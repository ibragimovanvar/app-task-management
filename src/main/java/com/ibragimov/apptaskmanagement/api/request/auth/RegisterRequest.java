package com.ibragimov.apptaskmanagement.api.request.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterRequest {

    @NotBlank
    @Size(min = 3, max = 55, message = "Your name is long! please take shorter one!")
    private String firstName;

    private String lastName;

    private String avatarUrl;

    @NotBlank
    @Size(min = 3, max = 60, message = "Your username is long! please take shorter one!")
    private String username;

    @NotBlank
    @Size(min = 8, max = 65, message = "Your password is of an invalid length.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    private String password;

    @Email
    private String email;

}
