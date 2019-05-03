package com.example.authservice.configuration;


public class CustomTokenStore{

//    private AuthenticationKeyGenerator authenticationKeyGenerator =
//            new DefaultAuthenticationKeyGenerator();
//
//    @Autowired
//    private TokenRefreshRepository tokenRefreshRepository;
//
//    @Autowired
//    private TokenAccessRepository tokenAccessRepository;

//    @Override
//    public OAuth2Authentication readAuthentication(OAuth2AccessToken token) {
//        return readAuthentication(token.getValue());
//    }
//
//    @Override
//    public OAuth2Authentication readAuthentication(String token) {
//        CustomAccessToken customAccessToken = tokenAccessRepository.findByTokenValue(token);
//        return customAccessToken != null ? customAccessToken.getAuthentication() : null;
//    }
//
//    @Override
//    public void storeAccessToken(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
//        String refreshToken = null;
//        if (accessToken.getRefreshToken() != null) {
//            refreshToken = accessToken.getRefreshToken().getValue();
//        }
////
////        if (readAccessToken(accessToken.getValue()) != null) {
////            this.removeAccessToken(accessToken);
////        }
//
//        CustomAccessToken customAccessToken = new CustomAccessToken().builder()
//                .id("1")
//                .tokenId("1")
//                .tokenValue(accessToken.getValue())
//                .authenticationId(authenticationKeyGenerator.extractKey(authentication))
//                .username(authentication.isClientOnly() ? null : authentication.getName())
//                .clientId(authentication.getOAuth2Request().getClientId())
//                .refreshToken(extractTokenKey(refreshToken))
//                .build();
//        customAccessToken.setAuthentication(authentication);
//
//        tokenAccessRepository.save(customAccessToken);
//    }
//
//    @Override
//    public OAuth2AccessToken readAccessToken(String tokenValue) {
//        CustomAccessToken customAccessToken = tokenAccessRepository.findByTokenValue(tokenValue);
//        OAuth2AccessToken oAuth2AccessToken = new DefaultOAuth2AccessToken(customAccessToken.getTokenValue());
//        return customAccessToken != null ? oAuth2AccessToken : null;
//    }
//
//    @Override
//    public void removeAccessToken(OAuth2AccessToken token) {
//        tokenAccessRepository.deleteByTokenValue(token.getValue());
//    }
//
//    @Override
//    public void storeRefreshToken(OAuth2RefreshToken refreshToken, OAuth2Authentication authentication) {
//        CustomRefreshToken customRefreshToken = new CustomRefreshToken().builder()
//                .tokenId(extractTokenKey(refreshToken.getValue()))
//                .token(refreshToken.getValue())
//                .build();
//        customRefreshToken.setAuthentication(authentication);
//
//        tokenRefreshRepository.save(customRefreshToken);
//    }
//
//    @Override
//    public OAuth2RefreshToken readRefreshToken(String tokenValue) {
//        CustomRefreshToken customRefreshToken = tokenRefreshRepository.findByToken(tokenValue);
//        OAuth2RefreshToken oAuth2RefreshToken = new DefaultOAuth2RefreshToken(customRefreshToken.getToken());
//        return customRefreshToken != null ? oAuth2RefreshToken : null;
//    }
//
//    @Override
//    public OAuth2Authentication readAuthenticationForRefreshToken(OAuth2RefreshToken token) {
//        CustomRefreshToken customRefreshToken = tokenRefreshRepository.findByToken(token.getValue());
//
//        return customRefreshToken != null ? customRefreshToken.getAuthentication() : null;
//    }
//
//    @Override
//    public void removeRefreshToken(OAuth2RefreshToken token) {
//        tokenRefreshRepository.deleteByToken(token.getValue());
//    }
//
//    @Override
//    public void removeAccessTokenUsingRefreshToken(OAuth2RefreshToken refreshToken) {
//        tokenAccessRepository.deleteByRefreshToken(refreshToken.getValue());
//    }
//
//    @Override
//    public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
//        OAuth2AccessToken accessToken = null;
//        String authenticationId = authenticationKeyGenerator.extractKey(authentication);
//
//        CustomAccessToken customAccessToken = tokenAccessRepository.findByAuthenticationId(authenticationId);
//        if (customAccessToken != null) {
//            accessToken = new DefaultOAuth2AccessToken(customAccessToken.getTokenValue());
//            if (accessToken != null && authenticationId.equals(this.authenticationKeyGenerator.extractKey(this.readAuthentication(accessToken)))) {
//                this.removeAccessToken(accessToken);
//                this.storeAccessToken(accessToken, authentication);
//            }
//        }
//        return accessToken;
//    }
//
//    @Override
//    public Collection<OAuth2AccessToken> findTokensByClientIdAndUserName(String clientId, String userName) {
//        return tokenAccessRepository.findAllOAuth2AccessTokensByClientIdAndUsername(clientId, userName);
//    }
//
//    @Override
//    public Collection<OAuth2AccessToken> findTokensByClientId(String clientId) {
//        return tokenAccessRepository.findAllOAuth2AccessTokensByClientId(clientId);
//    }
//
//    private String extractTokenKey(String value) {
//        if (value == null) {
//            return null;
//        } else {
//            MessageDigest digest;
//            try {
//                digest = MessageDigest.getInstance("MD5");
//            } catch (NoSuchAlgorithmException var5) {
//                throw new IllegalStateException("MD5 algorithm not available.  Fatal (should be in the JDK).");
//            }
//
//            try {
//                byte[] e = digest.digest(value.getBytes(StandardCharsets.UTF_8.name()));
//                return String.format("%032x", new BigInteger(1, e));
//            } catch (UnsupportedEncodingException var4) {
//                throw new IllegalStateException("UTF-8 encoding not available.  Fatal (should be in the JDK).");
//            }
//        }
//    }

}
