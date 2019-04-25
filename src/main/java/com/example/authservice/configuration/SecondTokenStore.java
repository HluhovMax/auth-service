package com.example.authservice.configuration;

import com.example.authservice.model.AT;
import com.example.authservice.model.RT;
import com.example.authservice.repository.ATRepo;
import com.example.authservice.repository.RTRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class SecondTokenStore implements TokenStore {


    private final RTRepo refRepo;
    private final ATRepo accRepo;

    public SecondTokenStore(RTRepo refRepo, ATRepo accRepo) {
        this.refRepo = refRepo;
        this.accRepo = accRepo;
    }

    @Override
    public OAuth2Authentication readAuthentication(OAuth2AccessToken token) {
        return null;
    }

    @Override
    public OAuth2Authentication readAuthentication(String token) {
        return null;
    }

    @Override
    public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        AT at = new AT().builder()
                .tokenValue(token.getValue())
                .clientId(authentication.getOAuth2Request().getClientId())
                .build();
        accRepo.save(at);
    }

    @Override
    public OAuth2AccessToken readAccessToken(String tokenValue) {
        return null;
    }

    @Override
    public void removeAccessToken(OAuth2AccessToken token) {

    }

    @Override
    public void storeRefreshToken(OAuth2RefreshToken refreshToken, OAuth2Authentication authentication) {
        RT rt = new RT().builder()
                .tokenValue(refreshToken.getValue())
                .clientId(authentication.getOAuth2Request().getClientId())
                .build();
        refRepo.save(rt);
    }

    @Override
    public OAuth2RefreshToken readRefreshToken(String tokenValue) {
        return null;
    }

    @Override
    public OAuth2Authentication readAuthenticationForRefreshToken(OAuth2RefreshToken token) {
        return null;
    }

    @Override
    public void removeRefreshToken(OAuth2RefreshToken token) {

    }

    @Override
    public void removeAccessTokenUsingRefreshToken(OAuth2RefreshToken refreshToken) {

    }

    @Override
    public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
        return null;
    }

    @Override
    public Collection<OAuth2AccessToken> findTokensByClientIdAndUserName(String clientId, String userName) {
        return null;
    }

    @Override
    public Collection<OAuth2AccessToken> findTokensByClientId(String clientId) {
        return null;
    }
}
