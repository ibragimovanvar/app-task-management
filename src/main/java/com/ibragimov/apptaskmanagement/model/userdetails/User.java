package com.ibragimov.apptaskmanagement.model.userdetails;


import com.ibragimov.apptaskmanagement.model.enums.SystemRoleName;
import com.ibragimov.apptaskmanagement.model.files.Attachment;
import com.ibragimov.apptaskmanagement.model.template.UUIDModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User extends UUIDModel implements UserDetails {

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String color;

    @OneToOne(fetch = FetchType.LAZY)
    private Attachment avatar;

    @Enumerated(EnumType.STRING)
    private SystemRoleName systemRoleName;

    private String emailCode;

    private boolean enabled = false;
    private boolean accountNonExpired=true;
    private boolean accountNonLocked=true;
    private boolean credentialsNonExpired=true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(systemRoleName.toString());
        return Collections.singleton(grantedAuthority);
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
