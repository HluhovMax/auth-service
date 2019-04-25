package com.example.authservice.repository;

import com.example.authservice.model.CustomAccessToken;
import com.example.authservice.model.CustomRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRefreshRepository extends JpaRepository<CustomRefreshToken, Long> {

    CustomRefreshToken findByToken(String token);

    void deleteByToken(String token);
}
