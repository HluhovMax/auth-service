package com.example.authservice.repository;

import com.example.authservice.model.AccessToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccessTokenRepo extends JpaRepository<AccessToken, Long> {

    Optional<AccessToken> findByTokenValue(String tokenValue);
}
