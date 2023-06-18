package com.example.spedox_mobile.services;

import com.example.spedox_mobile.models.DocumentRestModel;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 Document service
 */
public interface DocumentServiceApi {
    @Multipart
    @POST("api/document/new")
    Call<String> addDocument(@Part MultipartBody.Part file,
                             @Part("shipmentId") RequestBody shipmentId,
                             @Part("type") RequestBody type,
                             @Header("Authorization") String authToken);
}
