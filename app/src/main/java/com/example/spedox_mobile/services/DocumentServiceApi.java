package com.example.spedox_mobile.services;

import com.example.spedox_mobile.models.DocumentRestModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface DocumentServiceApi {

    @POST("/api/document/new")
    Call<String> addDocument(@Body DocumentRestModel documentRestModel, @Header("Authorization")String authToken);
}
