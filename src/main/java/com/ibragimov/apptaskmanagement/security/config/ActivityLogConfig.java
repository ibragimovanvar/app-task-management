package com.ibragimov.apptaskmanagement.security.config;

import com.ibragimov.apptaskmanagement.model.userdetails.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class ActivityLogConfig {
    @Bean
    public AuditorAware<User> getAuditorId(){
        return new ActivityLog();
    }
}
