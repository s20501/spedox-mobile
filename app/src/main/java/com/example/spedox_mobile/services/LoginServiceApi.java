package com.example.spedox_mobile.services;


import com.example.spedox_mobile.models.AuthTokenResponse;
import com.example.spedox_mobile.models.LoginModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
/**
 Login service
 */
public interface LoginServiceApi {
    @POST("api/auth/login")
    Call<AuthTokenResponse> login(@Body LoginModel loginModel);
}
