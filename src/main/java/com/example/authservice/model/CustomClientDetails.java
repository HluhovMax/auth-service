package com.example.authservice.model;

import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Entity that represents ClientDetails
 */
@Entity
@Data
public class CustomClientDetails implements ClientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, name = "enterprise_uuid")
    private String clientId;

    @Column(unique = true)
    private String clientSecret;

    private String grantTypes;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "scope_custom_client_details", joinColumns = {
            @JoinColumn(name = "client_details_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "scope_id", referencedColumnName = "id")})
    private List<Scope> scopes;

    private String resources;

    private String redirectUris;

    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    private String additionalInformation;

    @Override
    public Set<String> getResourceIds() {
        return resources != null ? new HashSet<>(Arrays.asList(resources.split(","))) : null;
    }

    @Override
    public boolean isSecretRequired() {
        return false;
    }

    @Override
    public boolean isScoped() {
        return true;
    }

    @Override
    public Set<String> getScope() {
        return scopes.stream()
                .map(Scope::getScope)
                .collect(Collectors.toSet());
//        String join = StringUtils.join(scopes.stream()
//                .map(scope -> scope.getScope())
//                .collect(Collectors.toList()).toArray(), ",");
//        Set<String> scope = new HashSet<>();
//        scope.add(join);
//        return scope;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return grantTypes != null ? new HashSet<>(Arrays.asList(grantTypes.split(","))) : null;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return redirectUris != null ? new HashSet<>(Arrays.asList(redirectUris.split(","))) : null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValidity;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValidity;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return true;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }


}
