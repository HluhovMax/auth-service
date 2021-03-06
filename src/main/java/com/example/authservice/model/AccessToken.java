package com.example.authservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity that represents Access Tokens
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccessToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String tokenValue;

    private String clientId;

    private Date expirationDate;

    @Enumerated(EnumType.STRING)
    private Status status;
}
