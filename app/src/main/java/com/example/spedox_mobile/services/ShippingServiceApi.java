package com.example.spedox_mobile.services;

import com.example.spedox_mobile.models.ShipmentModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

import java.util.List;

public interface ShippingServiceApi {
    @GET("api/shipment/all")
    Call<List<ShipmentModel>> getAllShipments(@Header("Authorization")String authToken);
}
