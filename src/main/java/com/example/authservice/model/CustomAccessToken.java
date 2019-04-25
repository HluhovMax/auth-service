package com.example.authservice.model;

import com.example.authservice.util.SerializableObjectConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "oauth_access_token")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomAccessToken {

    @Id
    private String id;
    private String tokenId;
    private String tokenValue;
    private String authenticationId;
    private String username;
    private String clientId;
    private String authentication;
    private String refreshToken;

    public OAuth2Authentication getAuthentication() {
        return SerializableObjectConverter.deserialize(authentication);
    }

    public void setAuthentication(OAuth2Authentication authentication) {
        this.authentication = SerializableObjectConverter.serialize(authentication);
    }
}
