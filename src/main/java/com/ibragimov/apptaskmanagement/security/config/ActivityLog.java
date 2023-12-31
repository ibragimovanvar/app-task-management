package com.ibragimov.apptaskmanagement.security.config;

import com.ibragimov.apptaskmanagement.model.userdetails.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class ActivityLog implements AuditorAware<User> {
    @Override
    public Optional<User> getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated() && !authentication.getPrincipal().equals("anonymousUser")) {
            return Optional.of((User) authentication.getPrincipal());
        }

        return Optional.empty();
    }
}
