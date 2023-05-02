package com.example.spedox_mobile.services;

import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ShippingServiceApi {
    @GET("/api/shipment/all")
    Call<ShipmentModel> getAllShipments(@Header("Authorization")String authToken);

}
