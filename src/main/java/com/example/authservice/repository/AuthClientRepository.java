package com.example.authservice.repository;

import com.example.authservice.model.AuthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthClientRepository extends JpaRepository<AuthClientDetails, Long> {

    Optional<AuthClientDetails> findByClientId(String clientId);
}
