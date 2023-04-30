package com.example.spedox_mobile.models;

public class AuthTokenResponse {
    private String accessToken;
    private String tokenType;

    public AuthTokenResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }
}
