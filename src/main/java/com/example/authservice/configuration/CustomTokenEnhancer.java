package com.example.authservice.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Use this class for customizing OAuth2AccessToken
 */
@Slf4j
@Component
public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        String clientId = authentication.getOAuth2Request().getClientId();

        Map<String, Object> additionalInfo = Map.of("clientId", clientId);

        DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
        token.setAdditionalInformation(additionalInfo);

        log.info("\nCLIENT ID: \n{}", token.getAdditionalInformation());
        return token;
    }
}
