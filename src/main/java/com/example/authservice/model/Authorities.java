package com.example.authservice.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Authorities implements GrantedAuthority {

    @Id
    private Long id;
    private String role;

    @Override
    public String getAuthority() {
        return this.role;
    }
}
