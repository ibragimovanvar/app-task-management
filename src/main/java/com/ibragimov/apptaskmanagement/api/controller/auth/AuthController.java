package com.ibragimov.apptaskmanagement.api.controller.auth;

import com.ibragimov.apptaskmanagement.api.request.auth.LoginRequest;
import com.ibragimov.apptaskmanagement.api.request.auth.RegisterRequest;
import com.ibragimov.apptaskmanagement.api.response.ApiResponse;
import com.ibragimov.apptaskmanagement.api.response.AuthResponse;
import com.ibragimov.apptaskmanagement.service.template.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        AuthResponse authResponse = authService.registerUser(request);
        return ResponseEntity.status(authResponse.isSuccessful() ? 200 : 409).body(authResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        AuthResponse authResponse = authService.loginUser(request);
        return ResponseEntity.status(authResponse.isSuccessful() ? 200 : 409).body(authResponse);
    }


    @PutMapping("/verifyEmail")
    public HttpEntity<?> verifyEmail(@RequestParam String email, @RequestParam String emailCode){
        AuthResponse authResponse = authService.verifyEmail(emailCode, email);
        return ResponseEntity.status(authResponse.getStatusCode()).body(authResponse);
    }

    /**
     * Handle validation exceptions
     * @param ex  exception to handle for validation errors in the request body
     * @return map of validation errors in the request body
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }




}
