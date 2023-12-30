package com.ibragimov.apptaskmanagement.service;

import com.ibragimov.apptaskmanagement.api.request.auth.LoginRequest;
import com.ibragimov.apptaskmanagement.api.request.auth.RegisterRequest;
import com.ibragimov.apptaskmanagement.api.response.AuthResponse;
import com.ibragimov.apptaskmanagement.dao.UserRepository;
import com.ibragimov.apptaskmanagement.exception.UserNotFoundException;
import com.ibragimov.apptaskmanagement.model.enums.SystemRoleName;
import com.ibragimov.apptaskmanagement.model.userdetails.User;
import com.ibragimov.apptaskmanagement.service.template.AuthService;
import com.ibragimov.apptaskmanagement.service.template.EmailService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
    }

    @Override
    public AuthResponse registerUser(RegisterRequest request) {
        if(userRepository.existsByUsernameOrEmailIgnoreCase(request.getUsername(), request.getEmail())) {
           return new AuthResponse(null, false, 409);
        }

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setSystemRoleName(SystemRoleName.SYSTEM_ROLE_USER);

        int code = new Random().nextInt(999999);
        user.setEmailCode(Integer.toString(code).substring(0, 4));

        userRepository.save(user);
        emailService.sendEmail(user.getEmail(), user.getEmailCode());

        return new AuthResponse(null, true, 200);
    }

    @Override
    public AuthResponse loginUser(LoginRequest request) {
        return null;
    }

    @Override
    public AuthResponse refreshToken(String refreshToken) {
        return null;
    }

    @Override
    public AuthResponse logoutUser(String refreshToken) {
        return null;
    }

    @Override
    public AuthResponse revokeToken(String refreshToken) {
        return null;
    }

    @Override
    public AuthResponse changePassword(String oldPassword, String newPassword) {
        return null;
    }

    @Override
    public AuthResponse forgotPassword(String email) {
        return null;
    }

    @Override
    public AuthResponse resetPassword(String token, String password) {
        return null;
    }

    @Override
    public AuthResponse verifyEmail(String emailCode, String email) {
        Optional<User> optionalUser = userRepository.findUserByEmail(email);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setEnabled(true);
            user.setEmailCode(null);
            userRepository.save(user);
            return new AuthResponse(null, true, 200);
        }

        return new AuthResponse(null, false, 404);
    }

    @Override
    public AuthResponse resendVerificationToken(String email) {
        return null;
    }


}
