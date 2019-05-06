package com.example.authservice.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity that represents Authorities, use when implement Password Grant_Type
 */
// comment this annotation when implement Password flow
@Entity
@Data
public class AuthenticationServiceAuthorities implements GrantedAuthority {

    @Id
    private Long id;
    private String role;

    @Override
    public String getAuthority() {
        return this.role;
    }
}
