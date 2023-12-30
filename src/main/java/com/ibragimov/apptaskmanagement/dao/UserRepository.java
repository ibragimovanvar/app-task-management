package com.ibragimov.apptaskmanagement.dao;

import com.ibragimov.apptaskmanagement.model.userdetails.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {


    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);

    boolean existsByUsernameOrEmailIgnoreCase(String username, String email);

}
