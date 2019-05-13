package com.example.authservice.configuration;

import com.example.authservice.repository.AuthClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Use this class for customizing OAuth2AccessToken.
 */

@Component
public class CustomTokenEnhancer implements TokenEnhancer {

    @Autowired
    private AuthClientRepository authClientRepository;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        String clientId = authentication.getOAuth2Request().getClientId();

        Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("clientId", clientId);

        DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
        token.setAdditionalInformation(additionalInfo);
        return token;
    }
}
