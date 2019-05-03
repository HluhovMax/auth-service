package com.example.authservice.configuration;

import com.example.authservice.model.AccessToken;
import com.example.authservice.model.RefreshToken;
import com.example.authservice.repository.AccessTokenRepo;
import com.example.authservice.repository.RefreshTokenRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;

@Slf4j
@Component
public class SecondTokenStore implements TokenStore {


    private final RefreshTokenRepo refRepo;
    private final AccessTokenRepo accRepo;

    public SecondTokenStore(RefreshTokenRepo refRepo, AccessTokenRepo accRepo) {
        this.refRepo = refRepo;
        this.accRepo = accRepo;
    }

    private final static String EQUALS = "\n === INTO ===";


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
        AccessToken accessToken = new AccessToken().builder()
                .tokenValue(token.getValue())
                .clientId(authentication.getOAuth2Request().getClientId())
                .build();
        accessToken = accRepo.save(accessToken);
        log.info(EQUALS + " storeAccessToken()\nwith access token: \n{}, \ntime: {}", accessToken, new Date());
    }

    @Override
    public OAuth2AccessToken readAccessToken(String tokenValue) {
        log.info(EQUALS + " readAccessToken() \nwith time: {}", new Date());
        return null;
    }

    @Override
    public void removeAccessToken(OAuth2AccessToken token) {

    }

    @Override
    public void storeRefreshToken(OAuth2RefreshToken refreshToken, OAuth2Authentication authentication) {
        RefreshToken rToken = new RefreshToken().builder()
                .tokenValue(refreshToken.getValue())
                .clientId(authentication.getOAuth2Request().getClientId())
                .build();
        rToken = refRepo.save(rToken);
        log.info(EQUALS + " storeRefreshToken()\nwith refresh rToken: \n{}, \ntime: {}", rToken, new Date());
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
        log.info(EQUALS + " getAccessToken() \nwith hello.message: {}", new Date());
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
