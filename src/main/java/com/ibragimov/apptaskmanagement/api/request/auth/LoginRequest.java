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
public class LoginRequest {

    @NotBlank(message = "Please provide a username or email.")
    private String usernameOrEmail;

    @NotBlank(message = "Please provide a password.")
    @Size(min = 8, max = 65, message = "Your password is of an invalid length.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Invalid password format.")
    private String password;

}
