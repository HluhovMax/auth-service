package com.example.authservice.repository;

import com.example.authservice.model.CustomAccessToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TokenAccessRepository extends JpaRepository<CustomAccessToken, Long> {

    CustomAccessToken findByTokenValue(String tokenValue);

    void deleteByTokenValue(String tokenValue);

    void deleteByRefreshToken(String refreshToken);

    CustomAccessToken findByAuthenticationId(String authId);

    Collection<OAuth2AccessToken> findAllOAuth2AccessTokensByClientIdAndUsername(String clientId, String userName);

    Collection<OAuth2AccessToken> findAllOAuth2AccessTokensByClientId(String clientId);
}
