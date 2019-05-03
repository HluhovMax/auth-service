package com.example.authservice.repository;

import com.example.authservice.model.CustomClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthClientRepository extends JpaRepository<CustomClientDetails, Long> {

    Optional<CustomClientDetails> findByClientId(String clientId);
}
