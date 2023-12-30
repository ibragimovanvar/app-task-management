package com.ibragimov.apptaskmanagement.service.template;

import com.ibragimov.apptaskmanagement.api.request.auth.LoginRequest;
import com.ibragimov.apptaskmanagement.api.request.auth.RegisterRequest;
import com.ibragimov.apptaskmanagement.api.response.AuthResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {

   AuthResponse registerUser(RegisterRequest request);

   AuthResponse loginUser(LoginRequest request);

   AuthResponse refreshToken(String refreshToken);

   AuthResponse logoutUser(String refreshToken);

   AuthResponse revokeToken(String refreshToken);

   AuthResponse changePassword(String oldPassword, String newPassword);

   AuthResponse forgotPassword(String email);

   AuthResponse resetPassword(String token, String password);

   AuthResponse verifyEmail(String emailCode, String email);

   AuthResponse resendVerificationToken(String email);

}
