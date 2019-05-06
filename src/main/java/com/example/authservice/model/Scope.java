package com.example.authservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Scope {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String scope;
}
