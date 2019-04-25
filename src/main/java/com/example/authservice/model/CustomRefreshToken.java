package com.example.authservice.model;

import com.example.authservice.util.SerializableObjectConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import javax.persistence.*;

@Entity
@Table(name = "oauth_refresh_token")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomRefreshToken {

    @Id
    private String id;
    private String tokenId;
    private String token;
    private String authentication;

    public OAuth2Authentication getAuthentication() {
        return SerializableObjectConverter.deserialize(authentication);
    }

    public void setAuthentication(OAuth2Authentication authentication) {
        this.authentication = SerializableObjectConverter.serialize(authentication);
    }
}
